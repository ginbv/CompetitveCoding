package mike.code.oj.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mike
 * @project oj-code
 * @date 3/28/15, 6:08 PM
 * @e-mail mike@mikecoder.net
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2,
                -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9,
                9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12,
                13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
        long start = System.currentTimeMillis();
        System.out.println(threeSum(nums));
        System.out.println("time is:" + (System.currentTimeMillis() - start));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new java.util.LinkedList<java.util.List<Integer>>();
        final int TARGET = 0;

        if (nums.length < 3) return result;

        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int res = nums[i] + nums[start] + nums[end];
                if (res == TARGET) {
                    LinkedList<Integer> pair = new java.util.LinkedList<Integer>();
                    pair.add(nums[i]);
                    pair.add(nums[start]);
                    pair.add(nums[end]);
                    if (!result.contains(pair)) {
                        result.add(pair);
                    }
                    start++;
                } else if (res < TARGET) {
                    start++;
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                } else {
                    end--;
                    while (nums[end] == nums[end + 1] && start < end) {
                        end--;
                    }
                }
            }
        }
        return result;
    }

}
