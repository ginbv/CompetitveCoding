package mike.code.oj.leetcode;

import java.util.LinkedList;

/**
 * @author Mike
 * @project oj.code
 * @date 6/28/15, 3:22 PM
 * @e-mail mike@mikecoder.net
 */
public class RegularExpressionMatching {

    class Node {
        String           token;
        LinkedList<Path> paths;
        boolean          isEnd;

        public Node(String token) {
            this.token = token;
            isEnd = false;
            this.paths = new LinkedList<Path>();
        }

        @Override
        public String toString() {
            return "Node{" + "token='" + token + '\'' + ", paths=" + paths + ", isEnd=" + isEnd + '}';
        }
    }

    class Path {
        String token;
        Node   next;

        public Path(String token, Node next) {
            this.token = token;
            this.next = next;
        }

        @Override
        public String toString() {
            String print;
            if (token != null && token.equals(next.token)) {
                print = "Path{" + "token='" + token + '\'' + ", next=" + next.token + '}';
            } else if (token == null) {
                print = "Path{" + "token='NULL" + '\'' + ", next=" + next + '}';
            } else {
                print = "Path{" + "token='" + token + '\'' + ", next=" + next + '}';
            }
            return print;
        }
    }

    private Node buildDFA(String regex) {
        Node start = new Node("START"), pre = start;
        for (int i = 0; i < regex.length();) {
            String current = "" + regex.charAt(i);
            if (i + 1 < regex.length() && regex.charAt(i + 1) == '*') {
                Node n = new Node(current), m = new Node(current);
                Path p = new Path(null, n), q = new Path(null, m);
                pre.paths.add(p);
                pre.paths.add(q);
                n.paths.add(new Path(current, n));
                n.paths.add(new Path(current, m));
                pre = m;
                i = i + 2;
            } else {
                Node n = new Node(current);
                Path p = new Path(current, n);
                pre.paths.add(p);
                pre = n;
                i = i + 1;
            }
        }
        pre.isEnd = true;
        return start;
    }

    private boolean checkDFA(Node start, int index, String str) {
        if (str.length() == index) {
            if (start.isEnd)
                return true;
            else if (start.paths.size() == 0) return false;
        }

        if (index > str.length()) return false;

        for (Path path : start.paths) {
            if (path.token == null) {
                if (checkDFA(path.next, index, str))
                    return true;
            } else if (index < str.length() && path.token.equals(".")) {
                if (checkDFA(path.next, index + 1, str))
                    return true;
            } else {
                if (index < str.length() && path.token.equals("" + str.charAt(index)))
                    if (checkDFA(path.next, index + 1, str))
                        return true;
            }
        }
        return false;
    }

    public boolean isMatch(String str, String regex) {
        Node start = buildDFA(regex);
        return checkDFA(start, 0, str);
    }

    public static void main(String[] args) {
        String str = "a", regex = "ab*";
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch(str, regex));
    }
}
