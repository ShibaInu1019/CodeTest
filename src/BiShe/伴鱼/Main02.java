package BiShe.伴鱼;

import java.util.Stack;

public class Main02 {

    public int minInsertions (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int ans =0;
        for (int i = 0; i <len ; i++) {
            if (s.charAt(i)=='('){
                stack.push('(');
                continue;
            }
            if (i+1==len){
                if (stack.isEmpty())
                    ans+=2;
                else {
                    stack.pop();
                    ans+=1;
                }
            }else {
                if (s.charAt(i+1)==')'){
                    if (stack.isEmpty()){
                        ans++;
                    }else {
                        stack.pop();
                    }
                    i++;
                }else {
                    if (stack.isEmpty()){
                        ans+=2;
                    }else {
                        ans++;
                        i++;
                    }
                }
            }
        }
        ans+=stack.size()*2;
        return ans;
    }


}
