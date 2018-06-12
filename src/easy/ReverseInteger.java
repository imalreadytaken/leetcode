package easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {

    private long result;
    private int flag;

    public int reverse(int x) {
        flag = x < 0 ? -1 : 1;
        result = 0;
        x = Math.abs(x);
        while (x > 0){
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        result = flag * result;
        if (result > Integer.MAX_VALUE || result <= Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1200));
    }

}
