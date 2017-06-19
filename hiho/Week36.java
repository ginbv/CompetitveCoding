package mike.code.oj.hiho;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author Mike
 * @project oj-code
 * @date 3/13/15, 12:38 AM
 * @e-mail mike@mikecoder.net
 */
public class Week36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int tar = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int index = Arrays.binarySearch(nums, tar);
            if (index >= 0) index++;
            else index = -1;
            System.out.println(index);
        }
    }
}
