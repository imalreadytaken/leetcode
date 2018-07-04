package hard;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * T may not be distinct, if so, S should contain all the repeat chars in T.
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 *
 * 对所有子串问题来说，都可以这么做
 * 维护两个首尾指针，尾指针从头开始往后走，
 * 如果两指针中间的子串满足条件了，则循环移动头指针直至条件不满足，中间记录需要记录的条件
 * 之后继续移动尾指针，
 * 如此循环遍历所有满足条件的子串，
 * 时间复杂度为O(n)
 *
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int counter = t.length(), begin = 0, end = 0, finalBegin = 0, finalEnd = 0, d = Integer.MAX_VALUE;
        char[] charS = s.toCharArray();
        while (end < s.length()){
            if (map[charS[end++]]-- > 0) counter--;
            while (begin < s.length() && counter == 0){
                if (end - begin < d){
                    d = end - begin;
                    finalBegin = begin;
                    finalEnd = end;
                }
                if (map[charS[begin++]]++ == 0) counter++;
            }
        }
        return s.substring(finalBegin, finalEnd);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABCC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

}
