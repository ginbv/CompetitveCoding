package mike.code.oj.micro.y2015.qual;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/17/15, 11:I16 AM
 * @e-mail mike@mikecoder.net
 */
public class P2 {

    private static int len;
    private static int num = 0;

    public static void setLen(int i) {
        len = i;
    }

    public static void getStringCombination(char[] k, int start, int wanted, String pre) {
        if (wanted == 0) {
            if (check(pre)) {
                num++;
            }
            return;
        }

        int last_index = len - wanted;
        for (int i = start; i <= last_index; i++) {
            getStringCombination(k, i + 1, wanted - 1, pre + k[i]);
        }
    }

    public static void getRs(String content) {
        for (int i = 1; i <= content.length(); i++) {
            getStringCombination(content.toCharArray(), 0, i, "");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                String content = scanner.next();
                setLen(content.length());
                getRs(content);
                System.out.println("Case #" + (i + 1) + ": " + num);
                num = 0;
            }
        }
    }

    public static boolean check(String str) {
        boolean b = true;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                b = false;
                break;
            }
        }
        return b;
    }
}
