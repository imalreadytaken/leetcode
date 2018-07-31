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
        int i = 0;
        char c;
        String tmp;
        int j;
        while (i < s.length()){
            c = s.charAt(i);
            if (c == '[') {
                strs.push("") ;
            }
            else if (c >= '0' && c <= '9'){
                j = 1;
                while (i+j < s.length() && s.charAt(i+j) >= '0' && s.charAt(i+j) <= '9') j++;
                ints.push( Integer.valueOf(s.substring(i, i+j)) );
                i += j;
                continue;
            }else if (c == ']'){
                tmp = "";
                while (!strs.peek().equals("")) tmp = strs.pop() + tmp;
                if (strs.size() > 0) strs.pop();
                strs.push(getRepeatString(tmp, ints.pop()));
            }else {
                j = 1;
                while (i+j < s.length() && s.charAt(i+j) != '[' && s.charAt(i+j) != ']' && s.charAt(i+j) < '0' && s.charAt(i+j) > '9') j++;
                strs.push(s.substring(i, i+ j));
                i += j;
                continue;
            }
            i++;
        }
        tmp = "";
        while (strs.size() > 0) tmp = strs.pop() + tmp;
        return tmp;
    }


    private String getRepeatString(String s, int repeat){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] ss = {"3[a]2[b4[F]c]","3[a]2[bc]", "3[a2[c]]","2[abc]3[cd]ef",};
        DecodeString d = new DecodeString();
        for (String s:ss) {
            System.out.println(d.decodeString(s));
        }
    }

}
