package mike.code.oj.leetcode;

/**
 * @author Mike
 * @project oj-code
 * @date 4/22/15, 8:52 PM
 * @e-mail mike@mikecoder.net
 */
public class HouseRobber {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 9, 4, 5 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
        return nums.length == 0 ? 0 : nums[nums.length - 1];
    }
}
