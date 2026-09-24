import java.util.Scanner;

public class balanced_brackets {
    static class Stack {
        private class Node {
            char val;
            Node next;
        }
        private Node top;
        public Stack() {
            top = null;
        }
        public void push(char val) {
            Node oldTop = top;
            top = new Node();
            top.val = val;
            top.next = oldTop;
        }
        public char pop() {
            char val = top.val;
            top = top.next;
            return val;
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
    static Scanner sc = new Scanner(System.in);
    static boolean isOpen(char val) {
        return (val == '{') || (val == '[') || (val == '(');
    }
    static char openOf(char val) {
        if (val == '}') {
            return '{';
        }
        if (val == ']') {
            return '[';
        }
        return '(';
    }
    static void solve() {
        String s = sc.next();
        int n = s.length();
        boolean isBalanced = true;
        Stack st = new Stack();
        for (int i = 0; i < n; ++i) {
            char val = s.charAt(i);
            if (isOpen(val)) {
                st.push(val);
            } else {
                if (st.isEmpty() || st.pop() != openOf(val)) {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (!st.isEmpty()) {
            isBalanced = false;
        }
        System.out.println(isBalanced ? "YES" : "NO");
    }
    public static void main(String[] args) {
        int T = sc.nextInt();
        while (T-- > 0) {
            solve();
        }
    }
}
/*
3
{[()]}
{[(])}
{{[[(())]]}}
*/