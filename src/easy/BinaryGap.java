package easy;

/**
 * too tired today. go for TV. bye.
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 *
 * If there aren't two consecutive 1's, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int res = 0, distance = 0;
        boolean haveOne = false;
        while (N > 0){
            if (N % 2 == 1){
                if (!haveOne) haveOne = true;
                else {
                    res = Math.max(res, ++distance);
                    distance = 0;
                }
            }else if (haveOne)distance++;
            N >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(8));
    }

}
