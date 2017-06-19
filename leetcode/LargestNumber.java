package mike.code.oj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mike
 * @project oj-code
 * @date 4/23/15, 5:32 PM
 * @e-mail mike@mikecoder.net
 */
public class LargestNumber {
    public static void main(String[] args) {
        int nums[] = { 4704, 6306, 9385, 7536, 3462, 4798, 5422, 5529, 8070, 6241,
                9094, 7846, 663, 6221, 216, 6758, 8353, 3650, 3836, 8183, 3516,
                5909, 6744, 1548, 5712, 2281, 3664, 7100, 6698, 7321, 4980, 8937,
                3163, 5784, 3298, 9890, 1090, 7605, 1380, 1147, 1495, 3699, 9448, 5208, 9456, 3846, 3567, 6856, 2000, 3575, 7205, 2697,
                5972, 7471, 1763, 1143, 1417, 6038, 2313, 6554, 9026, 8107, 9827, 7982, 9685, 3905, 8939, 1048, 282, 7423, 6327, 2970,
                4453, 5460, 3399, 9533, 914, 3932, 192, 3084, 6806, 273, 4283, 2060, 5682, 2, 2362, 4812, 7032, 810, 2465, 6511, 213, 2362,
                3021, 2745, 3636, 6265, 1518, 8398 };
        System.out.println(largestNumber(nums));
    }

    public static int compareString(String s1, String s2) {
        String tmp1 = s1 + s2;
        String tmp2 = s2 + s1;
        if (tmp1.compareTo(tmp2) > 0) {
            return -1;
        } else if (tmp1.compareTo(tmp2) < 0) {
                return 1;
        }
        return 0;
    }

    public static String largestNumber(int[] num) {
        List<String> listNums = new ArrayList<String>();
        for (int i = 0; i < num.length; ++i) {
            listNums.add(Integer.toString(num[i]));
            }
        Collections.sort(listNums, new Comparator() {
            public int compare(Object s1, Object s2) {
                return compareString((String) s1, (String) s2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < listNums.size(); ++i) {
            sb.append(listNums.get(i));
            }
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) != '0') {
                return sb.substring(i);
            }
        }
        return "0";
    }
}
