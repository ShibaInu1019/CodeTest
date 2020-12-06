package BiShe;

import java.util.Scanner;

public class MinStack {

    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private static Node head;

    public MinStack() {

    }

    public static void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public static void pop() {
        head = head.next;
    }

    public static int top() {
        return head.val;
    }

    public static int min() {
        return head.min;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (s.equals("pop")) {
                pop();
            }
            if (s.equals("top")) {
                System.out.println(top());
            }
            if (s.equals("getMin")) {
                System.out.println(min());
            } else {
                String[] strings = sc.next().split(" ");
                push(Integer.parseInt(strings[1]));
            }

        }

    }

}
