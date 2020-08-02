package LeetCode;

import java.util.Stack;

public class Offer31_Stack {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int i = 0, j = 0;
        //遍历入栈数组
        for (int e : pushed) {
            //赋值
            pushed[i] = e;
            //判断栈顶元素 == 出栈元素第一个
            while (i >= 0 && pushed[i] == popped[j]) {
                //出栈
                //j移动到下一个出栈元素的位置
                j++;
                //改变栈顶元素
                i--;
            }
            //继续入栈
            i++;
        }
        //判断栈是否为空
        return i == 0;
    }

    public boolean validateStackSequences_old(int[] pushed, int[] popped) {

        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int e : pushed) {
            stack.push(e);
            while (i >= 0 && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
