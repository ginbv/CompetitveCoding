package mike.code.oj.hiho;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/24/15, 11:09 AM
 * @e-mail mike@mikecoder.net
 */
public class P1032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                String str = scanner.next();
                char chars[] = new char[(str.length() + 1) * 2];
                chars[0] = '$';
                for (int j = 1; j < chars.length; j++) {
                    if (j % 2 == 1)
                        chars[j] = '#';
                    else chars[j] = str.charAt(j / 2 - 1);
                }

                int lens[] = new int[chars.length];
                int mid = 0, right = 0;
                for (int cur = 1; cur < chars.length; cur++) {
                    if (right > cur)
                        lens[cur] = Math.min(lens[2 * mid - cur], (right - cur));
                    else lens[cur] = 1;
                    try {
                        for (; chars[cur + lens[cur]] == chars[cur - lens[cur]]; lens[cur]++)
                            ;
                    } catch (Exception e) {} // 这边C++/C会有一个\0字符
                    if (lens[cur] + cur > right) {
                        right = lens[cur] + cur;
                        mid = cur;
                    }
                }
                int loc = 0, max = Integer.MIN_VALUE;
                for (int j = 1; j < chars.length; j++) {
                    if (lens[j] > max) {
                        max = lens[j];
                        loc = j;
                    }
                }

//                System.out.println(Arrays.toString(chars));
//                System.out.println(Arrays.toString(lens));
//                System.out.println(loc  + " " + max);
                StringBuilder strbuilder = new StringBuilder(chars.length);
                for (int j = loc - max + 1; j < loc + max; j++) {
                    if(chars[j] != '#'){
                        strbuilder.append(chars[j]);
                    }
                }
                System.out.println(strbuilder.toString());
            }
        }
    }
}
