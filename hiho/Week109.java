package mike.code.oj.hiho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj.code
 * @date 8/3/I16, 10:11 PM
 * @e-mail mike@mikecoder.cn
 */
public class Week109 {
    
    static class Node {
        public int in, out;
        public boolean         visited = false;
        public ArrayList<Node> nodes   = new ArrayList<Node>();
        
        public Node(int in, int out) {
            this.in = in;
            this.out = out;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Node node = (Node) o;
            
            if (in != node.in) return false;
            if (out != node.out) return false;
            return !(nodes != null ? !nodes.equals(node.nodes) : node.nodes != null);
            
        }
        
        @Override
        public int hashCode() {
            int result = in;
            result = 31 * result + out;
            result = 31 * result + (nodes != null ? nodes.hashCode() : 0);
            return result;
        }
        
        @Override
        public String toString() {
            return "Node{" + "in=" + in + ", out=" + out + ", visited=" + visited + ", nodes=" + nodes.size() + '}';
        }
    }
    
    static class NodeComparator implements Comparator {
        
        public int compare(Object obj1, Object obj2) {
            return -((Node) obj1).out + ((Node) obj2).out;
        }
    }
    
    static boolean checkAllChildIsLeaf(Node node) {
        if (node.nodes.size() > 0) {
            for (int i = 0; i < node.nodes.size(); i++) {
                if (node.nodes.get(i).nodes.size() > 1) {
                }
            }
            return true;
        }
        return false;
    }
    
    static void travelNodes(Node node) {
        if (node.visited) return;
        node.visited = true;
        for (Node child : node.nodes) {
            travelNodes(child);
        }
        if (checkAllChildIsLeaf(node)) {
            System.out.println(node);
            calcNode(node);
        }
        node.visited = false;
    }
    
    static Node calcNode(Node node) {
        Node[] nodes1 = new Node[node.nodes.size()];
        nodes1 = node.nodes.toArray(nodes1);
        Arrays.sort(nodes1, new NodeComparator());
        int x = 0, allin = 0, allout = 0;
        int res = Integer.MIN_VALUE;
        for (Node t : nodes1) {
            if (t.visited)
                continue;
            node.visited = false;
            if (res == Integer.MIN_VALUE) {
                res = t.in;
            }
            allin = allin + t.in;
            allout = allout + t.out;
            res = Math.max(t.in - x, res);
            x = x + t.out - t.in;
        }
        res = res + (node.in - node.out);
        node.out = res + (node.out + allout - node.in - allin);
        node.in = res;
        node.nodes.clear();
        return node;
    }
    
    public static void main(String[] args) {
        
        //        Node node1 = new Node(2, 1);
        //        node1.nodes.add(new Node(4, 3));
        //        Node node2 = new Node(2, 1);
        //        Node node3 = new Node(2, 1);
        //        node2.nodes.add(node3);
        //        node1.nodes.add(node2);
        //        travelNodes(node1);
        //        System.out.println(node1);
        int N;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            ArrayList<Node> nodes = new ArrayList<Node>();
            for (int i = 0; i < N; i++) {
                nodes.add(new Node(scanner.nextInt(), scanner.nextInt()));
            }
            for (int i = 0; i < N - 1; i++) {
                int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
                nodes.get(x).nodes.add(nodes.get(y));
                nodes.get(y).nodes.add(nodes.get(x));
            }
            travelNodes(nodes.get(0));
            System.out.println(nodes.get(0).in);
        }
    }
}
