package mike.code.oj.interview.I16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj.code
 * @date 8/7/16, 1:02 PM
 * @e-mail mike@mikecoder.cn
 */
public class P2 {

    static class Pos {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pos pos = (Pos) o;

            if (x != pos.x) return false;
            return y == pos.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static class Node {

        int             x;
        int             y;

        ArrayList<Node> nexts = new ArrayList<Node>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static int                pathA[] = new int[500];
    static int                pathB[] = new int[500];

    static HashSet<Node>      waterPs = new HashSet<Node>();
    static HashMap<Pos, Node> maps    = new HashMap<Pos, Node>();

    public static void main(String[] args) {
        int N, M, K, Q;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            waterPs.clear();
            maps.clear();

            N = scanner.nextInt();
            M = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                pathB[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                pathA[i] = scanner.nextInt();
            }
            K = scanner.nextInt();
            for (int i = 0; i < K; i++) {
                Node waterP = new Node();
                waterP.x = scanner.nextInt();
                waterP.y = scanner.nextInt();
                waterPs.add(waterP);
            }




            Q = scanner.nextInt();
            for (int i = 0; i < Q; i++) {
                Node startP = new Node();
                Node endP = new Node();

                startP.x = scanner.nextInt();
                startP.y = scanner.nextInt();
                endP.x = scanner.nextInt();
                endP.y = scanner.nextInt();

            }
        }
    }
}
