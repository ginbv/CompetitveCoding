package mike.code.oj.leetcode.NonnegativeIntegerswithoutConsecutiveOnes;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Mike
 * @project oj.code
 * @date 28/05/2017, 10:15 AM
 * @e-mail mike@mikecoder.cn
 */
public class Solution {
    public int findIntegers(int num) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        int res = 1;
        numbers.add(1);
        
        int currentNum;
        do {
            currentNum = numbers.poll();
            if (currentNum <= num) {
                res++;
            }
            if (currentNum % 2 == 0) {
                numbers.add(currentNum * 2);
                numbers.add(currentNum * 2 + 1);
            } else {
                numbers.add(currentNum * 2);
            }
        } while (currentNum <= num);
        return res;
    }
    
    public static void main(String[] args) {
        HashMap<Integer, Integer> DP = new HashMap<>();
        int pre = 0;
        for (int i = 0; i < 1000000000; i++) {
            int current = new Solution().findIntegers(i);
            if (current != pre) {
                pre = current;
                DP.put(i, current);
            }
        }
        System.out.println(DP.size());
    }
}