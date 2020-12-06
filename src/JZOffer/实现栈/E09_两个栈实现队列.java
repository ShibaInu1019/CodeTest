package JZOffer.实现栈;

import java.util.LinkedList;

/**
 * a栈用来添加，b栈用来删除
 * 队列删除时候先判断a，b是否为null，然后将a中元素存入b中准备删除
 * 如果a，b为null，说明队列为空，返回-1
 * 如果a不为null，就将a栈中的元素倒序放入b，进行删除
 * 如果b不为null，说明b中存在之前加入的元素，直接删除
 */
public class E09_两个栈实现队列 {

    LinkedList<Integer> a, b;

    public E09_两个栈实现队列() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void appendTail(int value) {
        a.addLast(value);
    }

    public int deleteHead() {
        //b中有之前添加的元素，直接删除
        if (!b.isEmpty()) return b.removeLast();
        //a，b为null说明队列为null，返回-1
        if (a.isEmpty()) return -1;
        //将a的元素添加到b
        while (!a.isEmpty()) {
            b.addLast(a.removeLast());
        }
        return b.removeLast();
    }
}
