package medium;

/**
 * 0 : 0
 * 1 : 10
 * 2 : 10 + 9 * 9
 * 3 : 10 + 9 * 9 + 9 * 9 * 8
 * 4 : 10 + 9 * 9 + 9 * 9 * 8 + 9 * 9 * 8 * 7
 * ...
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 *
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int sum = 10, tmp = 1, last = 9;
        while (tmp < n){
            last *= (10 - tmp++);
            sum += last;
        }
        return sum;
    }
}
