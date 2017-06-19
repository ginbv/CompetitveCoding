package mike.code.oj.leetcode;

/**
 * @author Mike
 * @project oj-code
 * @date 3/28/15, 3:28 PM
 * @e-mail mike@mikecoder.net
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        long closetSum = Integer.MAX_VALUE;
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int remainSum = target - nums[i];
            while (start < end) {
                int tsum = nums[start] + nums[end];
                if (tsum == remainSum) {
                    return target;
                } else if (tsum < remainSum) {
                    start++;
                } else {
                    end--;
                }

                if (Math.abs(remainSum - tsum) < Math.abs(target - closetSum)) {
                    closetSum = nums[i] + tsum;
                }
            }
        }
        return (int)closetSum;
    }
}
