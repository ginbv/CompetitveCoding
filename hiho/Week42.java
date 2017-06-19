package mike.code.oj.hiho;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/20/15, 9:50 PM
 * @e-mail mike@mikecoder.net
 */
public class Week42 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long num = scanner.nextLong();
            long cur = 4;
            long Vn3 = 1, Un2 = 3, Vn1 = 0, Un = 0;
            while (cur <= num) {
                Vn1 = (Un2 + Vn3) % 12357;
                Un = (2 * Vn1 + Un2) % 12357;
                cur = cur + 2;
                Vn3 = Vn1;
                Un2 = Un;
            }
            System.out.println(Un);
        }
    }
}
