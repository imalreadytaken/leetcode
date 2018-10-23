package medium;

import java.util.Arrays;

/**
 * 为a-z每个字母，存储以该字母结尾的子串的最大长度
 * 这样对每个字母，都有maxLen['?']个子串
 * 则将得到的26个长度加和即可
 *
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * <p>
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class UniqueSubstringsInWraparoundString {

    public int findSubstringInWraproundString(String p) {

        if (p.length() <= 1) return p.length();

        int[] maxLen = new int[26];
        maxLen[p.charAt(0) - 'a'] = 1;

        int maxConsis = 1;
        char cur, last;

        for (int i = 1; i < p.length(); i++) {
            cur = p.charAt(i);
            last = p.charAt(i - 1);
            if (cur - last == 1 || last - cur == 25){
                maxConsis++;
            }else {
                maxConsis = 1;
            }
            maxLen[cur - 'a'] = Math.max(maxLen[cur - 'a'], maxConsis);
        }

        return Arrays.stream(maxLen).sum();
    }

    public static void main(String[] args) {
        int n = new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyza");
        System.out.println(n);
    }

}
