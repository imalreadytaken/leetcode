package medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
//        boolean flag = (dividend>>>31) + divisor>>>31 == 1;  // 等于1为异号    会溢出
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long ldividend = Math.abs(((long)dividend));
        long ldivisor = Math.abs(((long)divisor));
        int multi = 0;
        long tmpMulti, tmpDivisor;
        while (ldividend > ldivisor){
            tmpMulti = 1;
            tmpDivisor = ldivisor;
            while (ldividend >= tmpDivisor){
                tmpDivisor <<= 1;
                tmpMulti <<= 1;
            }
            ldividend -= tmpDivisor>>1;
            multi += (tmpMulti>>1 > Integer.MAX_VALUE && !neg) ? Integer.MAX_VALUE : tmpMulti>>1;
        }
        if (ldividend == ldivisor) multi += 1;
        return neg ? -multi : multi;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-2147483648,1));
    }

}
