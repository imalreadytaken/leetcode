package hard;

/**
 * 61.25%
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 *
 * The 'closest' is defined as absolute difference minimized between two integers.
 *
 * Example 1:
 * Input: "123"
 * Output: "121"
 * Note:
 * The input n is a positive integer represented by string, whose length will not exceed 18.
 * If there is a tie, return the smaller one as answer.
 */
public class FindClosestPalindrome {

    StringBuilder mid, bigger, smaller;
    String resMid, resBigger, resSmaller;
    long lN, lMid, lSmaller, lBigger;
    int len, head, tail, largerHalf;
    public String nearestPalindromic(String n) {
        if (n.length() <= 1) return (Integer.valueOf(n) - 1) + "";
        if (n.length() == 2 && Integer.valueOf(n) < 20) {
            int tmp = Integer.valueOf(n);
            if (tmp > 11) return tmp < 17 ? "11" : "22";
            return "9";
        }
        len = n.length(); head = Math.round((float) len / 2); tail = len - head;
        largerHalf = Integer.valueOf(n.substring(0, head));
        mid = new StringBuilder(largerHalf + "");
        bigger = new StringBuilder(largerHalf + 1 + "");
        smaller = new StringBuilder(largerHalf - 1 + "");
        resMid = mid.toString() + mid.reverse().substring(mid.length()-tail);
        resBigger = bigger.toString() + bigger.reverse().substring(bigger.length()-tail);
        if((smaller.length()-tail) >= 0) {
            resSmaller = smaller.toString() + smaller.reverse().substring(smaller.length()-tail );
        }else {
            resSmaller = smaller.toString() + smaller.reverse();
            resSmaller += "9";
        }
        lN = Long.valueOf(n);
        lMid = Long.valueOf(resMid);
        lSmaller = Long.valueOf(resSmaller);
        lBigger = Long.valueOf(resBigger);
        if (lMid == lN) return lBigger-lMid < lMid-lSmaller ? resBigger : resSmaller;
        else if (lMid > lN) return lMid-lN < lN - lSmaller ? resMid : resSmaller;
        else return lBigger-lN < lN-lMid ? resBigger : resMid;
    }

    public static void main(String[] args) {
        String n = "999001";
        System.out.println(n);
        System.out.println(new FindClosestPalindrome().nearestPalindromic(n));
    }

}
