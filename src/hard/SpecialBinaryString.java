package hard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 把这个问题理解为从给定的字符串中找到所有的特殊子串（不重叠），然后对子串掐头去尾递归调用
 * 将所有结果按字典序逆序排列拼装返回
 * Special binary strings are binary strings with the following two properties:
 *
 * The number of 0's is equal to the number of 1's.
 * Every prefix of the binary string has at least as many 1's as 0's.
 * Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S, and swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)
 *
 * At the end of any number of moves, what is the lexicographically largest resulting string possible?
 *
 * Example 1:
 * Input: S = "11011000"
 * Output: "11100100"
 * Explanation:
 * The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
 * This is the lexicographically largest string possible after some number of swaps.
 * Note:
 *
 * S has length at most 50.
 * S is guaranteed to be a special binary string as defined above.
 */
public class SpecialBinaryString {

    public String makeLargestSpecial(String S) {
        if (S.length() <= 2) return S;
        ArrayList<String> specials = new ArrayList<>();
        int balance = 0, last = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0')
                balance--;
            else
                balance++;
            if (balance == 0)
            {
                specials.add("1" + makeLargestSpecial(S.substring(last + 1, i)) + "0");
                last = i + 1;
            }
        }
        Collections.sort(specials, Collections.reverseOrder());
        return String.join("", specials);
    }

    public static void main(String[] args) {
        String test = "11011000";
        System.out.println(new SpecialBinaryString().makeLargestSpecial(test));
    }

}
