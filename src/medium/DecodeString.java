package medium;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s.equals("")) return "";
        Stack<String> strs = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        String tmp;
        int last = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '[') {
                ints.push(Integer.valueOf(s.substring(last, i)));
                strs.push("");
                last = i + 1;
            }
            else if (c == ']'){
                if (s.charAt(i-1) != '[') {
                    if (last == i) {
                        tmp = getRepeatString(strs.pop(), ints.pop());
                    }
                    else {
                        tmp = getRepeatString(s.substring(last, i), ints.pop());
                        if (strs.peek().equals("")) strs.pop();
                        while ( strs.size() > 0 && !strs.peek().equals("") ) tmp = strs.pop() + tmp;
                    }
                    strs.pop();
                    strs.push((strs.size() > 0 && strs.peek() != "" ? strs.pop() : "") + tmp);
                }
                last = i + 1;
            }
            else if (c >= '0' && c <= '9'){
                if (i == 0 ) continue;
                if (s.charAt(i - 1) < '0' || s.charAt(i - 1) > '9'){
                    if (s.charAt(i - 1) != '[' && s.charAt(i - 1) != ']'){
                        strs.push(s.substring(last, i));
                    }
                    last = i;
                }
            }
        }
        if (last < s.length()) strs.push( (strs.size() > 0 ? strs.pop() : "") + s.substring(last));
        return strs.pop();
    }


    private String getRepeatString(String s, int repeat){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[b4[F]c]"));
    }

}
