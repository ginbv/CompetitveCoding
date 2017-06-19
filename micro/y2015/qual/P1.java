package mike.code.oj.micro.y2015.qual;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/17/15, 10:24 AM
 * @e-mail mike@mikecoder.net
 */
public class P1 {

    static final HashMap<String, Integer> months = new HashMap<String, Integer>();

    static {
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {

                int flag = 0; // years to reduce
                int sum = 0;

                String s_month_str = scanner.next();
                int s_month = months.get(s_month_str);
                String s_date_str = scanner.next();
                int s_date = Integer.valueOf(s_date_str.substring(0, s_date_str.length() - 1));
                long s_year = scanner.nextLong();
                if ((s_year % 4 == 0 && s_year % 100 != 0) || (s_year % 400 == 0)) {
                    if (s_month > 2) {
                        flag++;
                    }
                }
                String e_month_str = scanner.next();
                int e_month = months.get(e_month_str);
                String e_date_str = scanner.next();
                int e_date = Integer.valueOf(e_date_str.substring(0, e_date_str.length() - 1));
                long e_year = scanner.nextLong();
                if ((e_year % 4 == 0 && e_year % 100 != 0) || (e_year % 400 == 0)) {
                    if ((e_month < 2) || (e_month == 2 && e_date < 29)) {
                        flag++;
                    }
                }

                for (long year = s_year; year <= e_year; year++) {
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        sum++;
                    }
                }
                sum -= flag;
                System.out.println("Case #" + (i + 1) + ": " + sum);
            }
        }
    }
}
