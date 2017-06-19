package mike.code.oj.leetcode;

import java.util.HashSet;

/**
 * @author Mike
 * @project oj-code
 * @date 4/22/15, 8:23 PM
 * @e-mail mike@mikecoder.net
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(14));
    }

    static HashSet<Integer> sums = new HashSet<Integer>();

    public static boolean isHappy(int sum) {
        if (sum == 1) {
            sums.clear();
            return true;
        }
        if (sums.contains(sum)) {
            sums.clear();
            return false;
        }
        sums.add(sum);
        int res = 0;
        do {
            int i = sum % 10;
            sum /= 10;
            res += i * i;
        } while (sum != 0);
        return isHappy(res);
    }
}
