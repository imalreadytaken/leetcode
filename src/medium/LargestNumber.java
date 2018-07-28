package medium;

import java.util.Arrays;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    // a小于等于b返回0，否则返回1
//    private int compareInt(String a, String b){
//        if (a.length() == b.length()) return compareSameLenInt(a, b);
//        String longer = a.length() > b.length() ? a : b;
//        String shorter = a.length() > b.length() ? b : a;
//        int n = longer.length() - shorter.length();
//        String head = longer.substring(0, shorter.length());
//        if (head.equals(shorter)) return compareInt()
//    }
//
//    private int compareSameLenInt(String a, String b){
//        int i = 0;
//        while (a.charAt(i) == b.charAt(i)) i++;
//        if (i >= a.length()) return 0;  // 相等
//        return a.charAt(i) > b.charAt(i) ? 1 : 0;
//    }

    public String largestNumber(int[] nums) {
        List l = Arrays.asList(nums);
//        l.sort((Object x,Object y)->{
//            char[] xx = x.toString().toCharArray();
//            char[] yy = y.toString().toCharArray();
//            int curX = 0, curY = 0;
//            while (xx[curX] == yy[curY]){
//                if (curX == xx.length - 1 || curY == yy.length - 1){
//                    curX = Math.min(curX + 1, xx.length - 1);
//                    curY = Math.min(curY + 1, yy.length - 1);
//                    break;
//                }
//                curX++;curY++;
//            }
//            return ;
//        });
        return "";
    }
}
