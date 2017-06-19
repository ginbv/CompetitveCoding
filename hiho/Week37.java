package mike.code.oj.hiho;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 3/15/15, 2:38 PM
 * @e-mail mike@mikecoder.net
 */
public class Week37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int index = scanner.nextInt();

            int nums[] = new int[num];
    
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            if (index < 0 || index > num) {
                System.out.println(-1);
            }else {
                Arrays.sort(nums);
                System.out.println(nums[index - 1]);
            }
        }
    }
}
