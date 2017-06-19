package mike.code.oj.leetcode;

/**
 * @author Mike
 * @project oj.code
 * @date 02/04/2017, 1:08 PM
 * @e-mail mike@mikecoder.cn
 */
public class ComplexNumberMultiplication {
    
    class Num {
        int a;
        int b;
    
        @Override
        public String toString() {
            return a + "+" + b + "i";
        }
    }
    
    public Num convert(String num) {
        int real, fake;
        String[] nums = num.split("\\+");
        real = Integer.valueOf(nums[0]);
        fake = Integer.valueOf(nums[1].substring(0, nums[1].length() - 1));
        
        Num res = new Num();
        res.a = real;
        res.b = fake;
        
        return res;
    }
    
    public Num calc(Num num1, Num num2) {
        Num res = new Num();
        res.a = num1.a * num2.a - num1.b * num2.b;
        res.b = num1.b * num2.a + num1.a * num2.b;
        
        return res;
    }
    
    public String complexNumberMultiply(String a, String b) {
        Num num1 = convert(a);
        Num num2 = convert(b);
        
        Num res = calc(num1, num2);
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        ComplexNumberMultiplication complexNumberMultiplication = new ComplexNumberMultiplication();
        System.out.println(complexNumberMultiplication.complexNumberMultiply("-0+-12i", "-31+13i"));
    }
}
