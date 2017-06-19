package mike.code.oj.interview.I16;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj.code
 * @date 8/7/16, 1:15 PM
 * @e-mail mike@mikecoder.cn
 */
public class P3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine();
            String sentence = scanner.nextLine().trim();
            StringBuilder strBuilder = new StringBuilder(sentence);

            for (int i = 1; i < N; i++) {
                strBuilder.append(' ');
                strBuilder.append(sentence);
            }

            sentence = strBuilder.toString();

            int colNum = 1, cowNum = 0, times = 0, currentIdx = 0;

            int start = currentIdx;
            while (times < N) {
                start = currentIdx;
                currentIdx = currentIdx + M;
                if (currentIdx > sentence.length()) {
                    break;
                }

                colNum++;
                if (sentence.charAt(currentIdx) != ' ') {
                    while (sentence.charAt(currentIdx) != ' ') {
                        currentIdx--;
                    }
                    currentIdx++; // 空格可以放下
                }
            }
            cowNum = sentence.length() - currentIdx + M;
            System.out.println(colNum + " " + cowNum);
        }
    }
}
