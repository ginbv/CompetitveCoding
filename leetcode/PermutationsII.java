package mike.code.oj.leetcode;

import java.util.*;

/**
 * @author Mike
 * @project oj.code
 * @date 6/21/I16, 9:40 PM
 * @e-mail mike@mikecoder.cn
 */
public class PermutationsII {

    private HashSet<List<Integer>>    set    = new HashSet<List<Integer>>();
    private List<List<Integer>>       res    = new LinkedList<List<Integer>>();
    private HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res.clear();
        set.clear();
        numMap.clear();

        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.put(num, numMap.get(num) + 1);
            } else {
                numMap.put(num, 1);
            }
        }

        generateRes(nums, new LinkedList<Integer>());
        return res;
    }

    public void generateRes(int[] nums, LinkedList<Integer> current) {
        if (current.size() == nums.length && !set.contains(current)) {
            res.add((List<Integer>) current.clone());
            set.add((List<Integer>) current.clone());
        } else {
            Set<Integer> tset = new HashSet<Integer>(numMap.keySet());
            for (int num : tset) {
                current.push(num);
                if (numMap.get(num) == 1) {
                    numMap.remove(num);
                } else {
                    numMap.put(num, numMap.get(num) - 1);
                }
                generateRes(nums, current);
                int tnum = current.pop();
                if (numMap.containsKey(tnum)) {
                    numMap.put(tnum, numMap.get(tnum) + 1);
                } else {
                    numMap.put(tnum, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[] { 1, 1, 2 }));
        System.out.println(new PermutationsII().permuteUnique(new int[] { 1, 1, 2, 3, 4 }));
        System.out.println(new PermutationsII().permuteUnique(new int[] { 1, 1, 2, 3, 4, 5 }));
    }
}
