import java.util.Scanner;

public class queue_using_two_stacks {
    static class Stack {
        private class Node {
            int val;
            Node next;
        }
        private Node top;
        public Stack() {
            top = null;
        }
        public void push(int val) {
            Node oldTop = top;
            top = new Node();
            top.val = val;
            top.next = oldTop;
        }
        public int pop() {
            int val = top.val;
            top = top.next;
            return val;
        }
        public int peek() {
            return top.val;
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Stack st1 = new Stack();
        Stack st2 = new Stack();
        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int val = sc.nextInt();
                st1.push(val);
            } else {
                if (st2.isEmpty()) {
                    while (!st1.isEmpty()) {
                        int val = st1.pop();
                        st2.push(val);
                    }
                }
                if (type == 2) {
                    st2.pop();
                } else {
                    System.out.println(st2.peek());
                }
            }
        }
    }
}
/*
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2
*/