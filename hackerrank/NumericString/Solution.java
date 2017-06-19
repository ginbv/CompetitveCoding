package mike.code.oj.hackerrank.NumericString;


import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Mike
 * @project oj.code
 * @date 27/05/2017, 2:23 PM
 * @e-mail mike@mikecoder.cn
 */


public class Solution {
    
    static int changeDec(char ch) {
        int num = 0;
        if (ch >= 'A' && ch <= 'Z')
            num = ch - 'A' + 10;
        else if (ch >= 'a' && ch <= 'z')
            num = ch - 'a' + 36;
        else
            num = ch - '0';
        return num;
    }
    
    public static BigInteger toDecimal(String input, int base) {
        BigInteger Bigtemp = BigInteger.ZERO, temp = BigInteger.ONE;
        int len = input.length();
        for (int i = len - 1; i >= 0; i--) {
            if (i != len - 1)
                temp = temp.multiply(BigInteger.valueOf(base));
            int num = changeDec(input.charAt(i));
            Bigtemp = Bigtemp.add(temp.multiply(BigInteger.valueOf(num)));
        }
        return Bigtemp;
    }
    
    static int getMagicNumber(String s, int k, int b, int m) {
        Vector<BigInteger> numbers = new Vector<BigInteger>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            numbers.add(new BigInteger(s.substring(i, i + k)));
        }
        BigInteger res = new BigInteger("0");
        for (int i = 0; i < numbers.size(); i++) {
            res = res.add(toDecimal(numbers.elementAt(i).toString(), b).mod(new BigInteger(String.valueOf(m))));
        }
        return Integer.valueOf(res.toString(), 10);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int result = getMagicNumber(s, k, b, m);
        System.out.println(result);
    }
}

