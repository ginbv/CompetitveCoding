package mike.code.oj.hiho;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/5/15, 10:56 PM
 * @e-mail mike@mikecoder.net
 */
public class Week40 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            double Right = Integer.MIN_VALUE;
            double Left = Integer.MAX_VALUE;
            double Rx = Right / 2;
            double Lx = Left / 2;
            double Ly = Math.pow(Lx, 2) * a + b * Lx + c;
            double Ry = Math.pow(Rx, 2) * a + b * Rx + c;

            double Ldis = 0, Rdis = 0;
            do {
                Ldis = Math.pow(Lx - x, 2) + Math.pow(Math.pow(a * Lx, 2) + b * Ly + c - y, 2);
                Rdis = Math.pow(Rx - x, 2) + Math.pow(Math.pow(a * Rx, 2) + b * Ry + c - y, 2);
                if (Ldis > Rdis) {
                    Left = Lx;
                    Lx = Rx + (Left - Rx) / 2;
                    Rx = Rx + (Right - Rx) / 2;
                    Ly = Math.pow(Lx, 2) * a + b * Lx + c;
                    Ry = Math.pow(Rx, 2) * a + b * Rx + c;
                } else {
                    Right = Rx;
                    Rx = Lx + (Right - Lx) / 2;
                    Lx = Lx + (Left - Lx) / 2;
                    Ly = Math.pow(Lx, 2) * a + b * Lx + c;
                    Ry = Math.pow(Rx, 2) * a + b * Rx + c;
                }
            } while (Math.abs(Lx - Rx) >= 0.001);
            //((X - x)^2+(aX^2+bX+c-y)^2;

            System.out.printf("%.3f", Ldis);
        }
    }
}
