package mike.code.oj.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mike
 * @project oj-code
 * @date 3/28/15, 7:37 PM
 * @e-mail mike@mikecoder.net
 */
public class FourSum {
    public static void main(String[] args) {
        int nums[] = { 0, 0, 0, 0 };
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums.length < 4) return res;

        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> tmp = threeSum(nums, target - nums[i], i);
            res.addAll(tmp);
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int TARGET, int begin) {
        List<List<Integer>> result = new java.util.LinkedList<java.util.List<Integer>>();

        if (nums.length - begin < 3) return result;

        for (int i = begin + 1; i < nums.length; i++) {
            if (i > begin + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int res = nums[i] + nums[start] + nums[end];
                if (res == TARGET) {
                    java.util.LinkedList<Integer> pair = new java.util.LinkedList<Integer>();
                    pair.add(nums[begin]);
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
