package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 左边比右边多时不考虑直接跳过，然后反转字符串再来一遍
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i) == '(' ? ')' : '(');
        }
        System.out.println(sb.toString());
        return Math.max(_longestValidParentheses(s), _longestValidParentheses(sb.toString()));
    }

    private int _longestValidParentheses(String s) {
        int begin = 0, end = 0, res = 0;
        int[] counter = new int[')'+1];
        char[] chars = s.toCharArray();
        while (end < s.length()){
            counter[chars[end++]]++;
            if (counter['('] < counter[')']) {
                begin = end;                                                        // 右括号比左括号多
                counter['('] = counter [')'] = 0;
            }
            else if (counter['('] == counter[')'] && counter['('] != 0) {           // 左右括号一样多
                res = Math.max(res, end - begin);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }

}
