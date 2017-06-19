package mike.code.oj.micro.y2015.preliminary.second;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/26/15, 3:05 PM
 * @e-mail mike@mikecoder.net
 */
public class P2 {

    static class path {
        public int start;
        public int end;

        public path(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int k = scanner.nextInt();


                ArrayList<path> paths = new ArrayList<path>(m);
                int[] cities = new int[n];
                int map[][] = new int[n][n];
                for (int j = 0; j < n; j++) {
                    cities[j] = scanner.nextInt();
                }
                for (int j = 0; j < m; j++) {
                    int start = scanner.nextInt() - 1;
                    int end = scanner.nextInt() - 1;
                    map[start][end] = scanner.nextInt();
                    paths.add(new path(start, end));
                }

                for (int j = 0; j < paths.size(); j++) {
                    for (int l = j + 1; l < paths.size(); l++) {
                        for (int o = 0; o < n; o++) {
                            for (int p = 0; p < n; p++) {

                            }
                        }
                    }
                }

            }
        }
    }

    public int calcMap(int[][] map, int[] nodes) {
        int[] visited = new int[nodes.length];

        return 0;
    }
}
