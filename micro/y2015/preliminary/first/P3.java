package mike.code.oj.micro.y2015.preliminary.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/25/15, 1:14 PM
 * @e-mail mike@mikecoder.net
 */
public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int nums[] = new int[N];
                for (int j = 0; j < N; j++) {
                    nums[j] = scanner.nextInt();
                }
            }
        }
    }

    public static int dealNums(int[] nums) {
        Arrays.sort(nums);
        return 0;
    }

    public static boolean IsPrime3(long n) {
        if (n < 2) {
            // 小于2的数即不是合数也不是素数
            return false;
        }
        long aPrimeList[] = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        };

        for (int i = 0; i < aPrimeList.length; ++i) {
            // 按照素数表中的数对当前素数进行判断
            if (1 != Montgomery(aPrimeList[i], n - 1, n)) // 蒙格马利算法
            {
                return false;
            }
        }
        return true;
    }

    static long Montgomery(long n, long p, long m) { //快速计算(n^p)%m的值
        long k = 1;
        n %= m;
        while (p != 1) {
            if (0 != (p & 1)) k = (k * n) % m;
            n = (n * n) % m;
            p >>= 1;
        }
        return (n * k) % m;
    }
}
