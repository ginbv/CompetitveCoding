package mike.code.oj.micro.y2015.preliminary.second;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/26/15, 2:49 PM
 * @e-mail mike@mikecoder.net
 */
public class P3 {

    static class Node {
        int type;

        @Override
        public String toString() {
            return "{" + type + '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ":");
                int N = scanner.nextInt();
                int M = scanner.nextInt();
                int Q = scanner.nextInt();

                int MAP[][] = new int[N][N];
                int[] nodes = new int[N];
                for (int j = 0; j < N; j++) {
                    int type = scanner.nextInt();
                    nodes[j] = type;
                }

                for (int j = 0; j < M; j++) {
                    int start = scanner.nextInt() - 1;
                    int end = scanner.nextInt() - 1;
                    int value = scanner.nextInt();

                    MAP[start][end] = value;
                    MAP[end][start] = value;
                }

                for (int j = 0; j < Q; j++) {
                    int type = scanner.nextInt();
                    if (type == 1) {
                        int no = scanner.nextInt() - 1;
                        nodes[no] = nodes[no] == 1 ? 0 : 1;
                    } else if (type == 2) {
                        int start = scanner.nextInt() - 1;
                        int end = scanner.nextInt() - 1;
                        int value = scanner.nextInt();

                        MAP[start][end] = value;
                        MAP[end][start] = value;
                    } else if (type == 3) {
                        int sum = 0;
                        for (int k = 0; k < N; k++) {
                            for (int l = k; l < N; l++) {
                                if (nodes[k] != nodes[l]) {
                                    sum = sum + MAP[k][l];
                                }
                            }
                        }
                        System.out.println(sum);
                    }
                }
            }
        }
    }
}
