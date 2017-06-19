package mike.code.oj.micro.y2015.qual;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/17/15, 1:46 PM
 * @e-mail mike@mikecoder.net
 */
public class P3 {

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" + "x=" + x + ", y=" + y + '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int N = scanner.nextInt();
                int M = scanner.nextInt();
                int A = scanner.nextInt();
                int B = scanner.nextInt();

                ArrayList<Location> AL = new ArrayList<Location>(A);
                ArrayList<Location> BL = new ArrayList<Location>(B);

                for (int j = 0; j < A; j++) {
                    AL.add(new Location(scanner.nextInt(), scanner.nextInt()));
                }

                for (int j = 0; j < B; j++) {
                    BL.add(new Location(scanner.nextInt(), scanner.nextInt()));
                }

                long MinCost = Integer.MAX_VALUE;
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= M; k++) {
                        long cost = calc(AL, BL, j, k);
                        MinCost = MinCost < cost ? MinCost : cost;
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + MinCost);
            }
        }
    }

    public static long calc(ArrayList<Location> Al, ArrayList<Location> Bl, int lx, int ly) {
        int res = 0;
        for (Location loc : Al) {
            res += (lx - loc.x) * (lx - loc.x) + (ly - loc.y) * (ly - loc.y);
        }

        int cost = Integer.MAX_VALUE;
        for (Location loc : Bl) {
            int t = Math.abs(lx - loc.x) + Math.abs(ly - loc.y);
            cost = cost < t ? cost : t;
        }
        return res + cost;
    }
}
