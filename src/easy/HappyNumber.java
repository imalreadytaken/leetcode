package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    Set<Integer> tmp = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (tmp.contains(n))
            return false;
        tmp.add(n);
        int next = 0;
        while (n > 0){
            int a = n % 10;
            next += a * a;
            n /= 10;
        }
        return isHappy(next);
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
