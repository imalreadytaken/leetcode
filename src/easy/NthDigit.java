package easy;

/**
 *
 * 主要需要处理溢出的情况
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit {

    public int findNthDigit(int n) {
        int len = 1, level = 1;
        int tmp = 9 * len * level;
        while (tmp > 0 && n > tmp){
            n -= 9 * len++ * level;
            if (len > 10){
                break;
            };
            level *= 10;
            tmp = 9 * len * level;
        }
        n = level == 1 ? n : n-1;
        level = level == 1 ? 0 : level;
        level += n / len;
        n %= len;
        String s = level + "";
        return Integer.valueOf(s.substring(n, n + 1));
    }

    public static void main(String[] args) {
        System.out.println(new NthDigit().findNthDigit(1073741823));
    }


}
