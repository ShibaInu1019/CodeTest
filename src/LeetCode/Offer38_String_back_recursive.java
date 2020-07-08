package LeetCode;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Offer38_String_back_recursive {


    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            //存入res中
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            //是否有元素重复，跳过重复序列（剪枝）
            if (set.contains(c[i]))
                continue;
            //添加到set中
            set.add(c[i]);
            swap(i, x);//交换
            dfs(x + 1);//递归下一个字符
            swap(i, x);//恢复交换
        }
    }

    //交换两个字符
    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }


}
