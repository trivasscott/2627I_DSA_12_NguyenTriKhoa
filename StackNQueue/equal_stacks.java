import java.util.Scanner;

public class equal_stacks {
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
        int[] n = new int[3];
        for (int i = 0; i < 3; ++i) {
            n[i] = sc.nextInt();
        }
        Stack[] st = new Stack[3];
        int[] h = new int[3];
        for (int i = 0; i < 3; ++i) {
            int[] a = new int[n[i]];
            for (int j = 0; j < n[i]; ++j) {
                a[j] = sc.nextInt();
            }
            st[i] = new Stack();
            h[i] = 0;
            for (int j = n[i] - 1; j >= 0; --j) {
                st[i].push(a[j]);
                h[i] += a[j];
            }
        }
        int ans = 0;
        while (!st[0].isEmpty() && !st[1].isEmpty() && !st[2].isEmpty()) {
            int cur = Math.max(h[0], Math.max(h[1], h[2]));
            if (h[0] == cur && h[1] == cur && h[2] == cur) {
                ans = Math.max(ans, cur);
            }
            for (int i = 0; i < 3; ++i) {
                if (h[i] == cur) {
                    h[i] -= st[i].pop();
                }
            }
        }
        System.out.println(ans);
    }
}
/*
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
*/