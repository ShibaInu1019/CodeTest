package StringTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "select * from emp where name = #{name} and id = #{id}";

        //获取以 #{ 开始，不是 } 结尾的多个字符 (其中()用来分组)
        Pattern p = Pattern.compile("#\\{([^}]+)");
        Matcher m = p.matcher(str);

        //获取 #{} 中的内容
        while (m.find()) {
            System.out.println(m.group(1));
        }

        //替换#{xxx}
        str = str.replaceAll("#\\{[^}]+\\}", "?");
        System.out.println(str);
    }
}
