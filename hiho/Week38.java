package mike.code.oj.hiho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 3/26/15, 8:04 PM
 * @e-mail mike@mikecoder.net
 */
public class Week38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            int T = scanner.nextInt() - 1;

            int L = Integer.MAX_VALUE, R = Integer.MIN_VALUE;

            ArrayList<LinkedList<Path>> paths = new ArrayList<LinkedList<Path>>(N);

            for (int i = 0; i < N; i++) {
                paths.add(new LinkedList<Path>());
            }

            for (int i = 0; i < M; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                int v = scanner.nextInt();

                Path path1 = new Path(x, y, v);
                Path path2 = new Path(y, x, v);

                paths.get(x).add(path1);
                paths.get(y).add(path2);

                R = R > v ? R : v;
                L = L < v ? L : v;
            } // init end


            if (fx(L, paths, T, K, N)) {
                System.out.println(L);
            } else {
                while (R - L != 1) {
                    int mid = R - ((R - L) / 2);
                    if (fx(mid, paths, T, K, N)) {
                        R = mid;
                    } else {
                        L = mid;
                    }
                }
                System.out.println(R);
            }
        }
    }

    public static boolean fx(int value, ArrayList<LinkedList<Path>> paths, int T, int K, int N) {
        int remains = K;

        LinkedList<Integer> currentPostion = new LinkedList<Integer>();
        LinkedList<Integer> nextPosition = new LinkedList<Integer>();
        LinkedList<Integer> tmp = null;
        currentPostion.add(0);

        while (!(currentPostion.isEmpty() && nextPosition.isEmpty()) && remains > 0) {
            while (!currentPostion.isEmpty() && remains > 0) {
                int current = currentPostion.pop();
                nextPosition = new LinkedList<Integer>();

                for (Path path : paths.get(current)) {
                    if (path.end == current) continue;
                    if (path.value <= value) {
                        if (path.end == T) {
                            return true;
                        } else {
                            nextPosition.add(path.end);
                        }
                    }
                }
            }

            remains--;
            tmp = currentPostion;
            currentPostion = nextPosition;
            nextPosition = tmp;
        }

        return false;
    }

    static class Path {
        public int start;
        public int end;
        public int value;


        Path(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Path{" + "start=" + start + ", end=" + end + ", value=" + value + '}';
        }
    }
}
