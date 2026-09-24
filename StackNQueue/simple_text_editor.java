import java.util.Scanner;

public class simple_text_editor {
    static class Stack {
        public class Node {
            int k;
            String w;
            Node next;
        }
        private Node top;
        public Stack() {
            top = null;
        }
        public void push(int k) {
            Node oldTop = top;
            top = new Node();
            top.k = k;
            top.w = null;
            top.next = oldTop;
        }
        public void push(String w) {
            Node oldTop = top;
            top = new Node();
            top.k = w.length();
            top.w = w;
            top.next = oldTop;
        }
        public Node pop() {
            Node ans = top;
            top = top.next;
            return ans;
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
    static Scanner sc = new Scanner(System.in);
    static char[] a = new char[1000000];
    public static void main(String[] args) {
        int q = sc.nextInt();
        int curId = -1;
        Stack acts = new Stack();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 3) {
                int k = sc.nextInt();
                System.out.println(a[k - 1]);
            } else if (type == 1) {
                String w = sc.next();
                int k = w.length();
                for (int i = 0; i < k; ++i) {
                    ++curId;
                    a[curId] = w.charAt(i);
                }
                acts.push(k);
            } else if (type == 2) {
                int k = sc.nextInt();
                StringBuilder sb = new StringBuilder();
                for (int i = curId - k + 1; i <= curId; ++i) {
                    sb.append(a[i]);
                }
                curId -= k;
                String w = sb.toString();
                acts.push(w);
            } else {
                Stack.Node act = acts.pop();
                if (act.w == null) {
                    curId -= act.k;
                } else {
                    for (int i = 0; i < act.w.length(); ++i) {
                        ++curId;
                        a[curId] = act.w.charAt(i);
                    }
                }
            }
        }
    } 
}
/*
8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
*/