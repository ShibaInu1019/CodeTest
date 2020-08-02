package BiShe;

import java.io.File;
import java.util.*;

/**
 * D盘文件排序输出
 */
public class Test01_0727 {

    //文件排序
    public static List<File> fileSort(File file) {
        List<File> filelist = recursive(file);
        if (filelist != null && filelist.size() > 0) {
            //重写比较器
            Collections.sort(filelist, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    if (o1.lastModified() > o2.lastModified())
                        return 1;
                    else if (o1.lastModified() == o2.lastModified())
                        return 0;
                    else
                        return -1;
                }
            });
        }
        return filelist;
    }

    //递归查找文件
    public static List<File> recursive(File files) {
        List<File> list = new ArrayList<>();
        if (files.exists()) {
            //获取所有文件
            File[] file = files.listFiles();
            if (file != null) {
                for (File file1 : file) {
                    //检测是否是文件夹
                    if (file1.isDirectory()) {
                        //递归
                        recursive(file1);
                    } else {
                        System.out.println("路径：" + file1.getAbsolutePath() + "时间：" + new Date(file1.lastModified()));
                        list.add(file1);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //获取盘符
        File[] root = File.listRoots();
        String str = Arrays.toString(root);
        if (str.contains("D:")) {
            File files = new File("D:\\");
            List<File> fileList = fileSort(files);
            for (File file : fileList) {
                System.out.println("路径：" + file.getAbsolutePath() + "时间：" + new Date(file.lastModified()));
            }
        }
    }

}
