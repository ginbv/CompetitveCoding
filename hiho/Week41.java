package mike.code.oj.hiho;

import java.util.Scanner;

/**
 * @author Mike
 * @project oj-code
 * @date 4/12/15, 3:32 AM
 * @e-mail mike@mikecoder.net
 */
public class Week41 {

    static class Matrix {
        long[][] m = new long[2][2];
    }

    static Matrix matmul(Matrix b, Matrix c, long mm) {
        int i, j, k;
        Matrix d = new Matrix();
        for (i = 0; i < 2; i++)
            for (j = 0; j < 2; j++)
                for (k = 0; k < 2; k++) {
                    d.m[i][j] += b.m[i][k] * c.m[k][j];
                    d.m[i][j] %= mm;
                }
        return d;
    }

    static Matrix matpow(Matrix f, Matrix ff, long k, long m) {
        while (k > 0) {
            if (k % 2 == 1)
                ff = matmul(ff, f, m);
            f = matmul(f, f, m);
            k /= 2;
        }
        return ff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long N = scanner.nextLong() - 1;

            Matrix aa = new Matrix();
            Matrix bb = new Matrix();
            Matrix cc = null;
            aa.m[0][1] = 1;//构建矩阵
            aa.m[1][0] = 1;
            aa.m[1][1] = 1;
            bb.m[0][1] = 1;

            cc = matpow(aa, bb, N + 2, 19999997);
            System.out.println((int) cc.m[0][0]);
        }
    }
}
