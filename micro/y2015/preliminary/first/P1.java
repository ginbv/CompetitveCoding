package mike.code.oj.micro.y2015.preliminary.first;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/25/15, 1:14 PM
 * @e-mail mike@mikecoder.net
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ":");
                int n = scanner.nextInt();
                TreeNode[] treeNodes = new TreeNode[n];
                treeNodes[0] = new TreeNode();
                treeNodes[0].no = 0;
                treeNodes[0].value = 0;
                treeNodes[0].children = new LinkedList<TreeNode>();
                int visited[] = new int[n];
                for (int j = 0; j < n - 1; j++) {
                    int parent = scanner.nextInt() - 1;
                    int child = scanner.nextInt() - 1;
                    if (treeNodes[parent] == null) {
                        treeNodes[parent] = new TreeNode();
                        treeNodes[parent].no = parent;
                        treeNodes[parent].value = 0;
                        treeNodes[parent].children = new LinkedList<TreeNode>();
                    }
                    if (treeNodes[child] == null) {
                        treeNodes[child] = new TreeNode();
                        treeNodes[child].value = 0;
                        treeNodes[child].no = child;
                        treeNodes[child].children = new LinkedList<TreeNode>();
                    }
                    treeNodes[parent].children.add(treeNodes[child]);
                }
                int q = scanner.nextInt();
                for (int j = 0; j < q; j++) {
                    int type = scanner.nextInt();
                    if (type == 1) {
                        for (int k = 0; k < visited.length; k++) {
                            visited[k] = 0;
                        }
                        System.out.println(checkTree(treeNodes[0], visited));
                    }
                    if (type == 2) {
                        int nodeNum = scanner.nextInt() - 1;
                        treeNodes[nodeNum].value = scanner.nextInt();
                    }
                }
            }
        }
    }

    public static int checkTree(TreeNode root, int[] visited) {
        visited[root.no] = 1;
        int sum = 1;
        LinkedList<TreeNode> diff = new LinkedList<TreeNode>();
        LinkedList<TreeNode> same = new LinkedList<TreeNode>();
        for (TreeNode child : root.children) {
            if (visited[child.no] == 1) continue;
            if (child.value != root.value) {
                diff.add(child);
            } else {
                same.add(child);
            }
        }
        while (same.size() > 0) {
            TreeNode next = same.pop();
            for (TreeNode child : next.children) {
                if (visited[child.no] == 1) continue;
                if (child.value != next.value) {
                    diff.add(child);
                } else {
                    same.add(child);
                }
            }
        }
        for (TreeNode node : diff) {
            sum = sum + checkTree(node, visited);
        }
        return sum;
    }

    static class TreeNode {
        public int                  value;
        public int                  no;
        public LinkedList<TreeNode> children;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
