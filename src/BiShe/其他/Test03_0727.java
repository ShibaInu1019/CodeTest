package BiShe.其他;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析在线json
 */
public class Test03_0727 {

    public static String load(String url) {
        StringBuilder json = new StringBuilder();
        try {
            //创建url
            URL urlString = new URL(url);
            //建立连接
            URLConnection urlConnection = urlString.openConnection();
            //得到输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String input = null;
            //读取每一行数据判断是否为空
            while ((input = in.readLine()) != null) {
                json.append(input);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }


    public static void download(String url, String name, String path) {
        try {
            URL urlString = new URL(url);
            URLConnection urlConnection = urlString.openConnection();
            //设置超时时间
            urlConnection.setConnectTimeout(5000);
            InputStream in = urlConnection.getInputStream();
            //缓冲区
            byte[] bs = new byte[1024];
            int len;
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream out = new FileOutputStream(file.getPath() + "\\" + name);
            while ((len = in.read(bs)) != -1) {
                out.write(bs, 0, len);
            }
            out.close();
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String json = load("http://123.56.191.196:8080/a/a/d/list_slide_1_0.json");
        List<String> list = new ArrayList<>();
        String[] strings = json.trim().split(",\\{");
        for (int i = 0; i < strings.length; i++) {
            //添加图片url
            list.add(strings[i].split(",")[2].split(":", 2)[1]);
        }
        for (int i = 0; i < list.size(); i++) {
            //下载图片
            download(list.get(i).replace("\"", ""), "picture" + i + ".jpg", "D:\\download");
        }
        System.out.println("下载成功！");

    }
}
