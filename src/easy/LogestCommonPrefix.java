package easy;

/**
 * 找出字典序最大最小的两个进行比较
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LogestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String min = strs[0], max = min;
        for (String s : strs ) {
            min = s.compareTo(min) < 0 ? s : min;
            max = s.compareTo(max) > 0 ? s : max;
        }
        int index = 0;
        for (; index < min.length(); index++) {
            if (min.charAt(index) != max.charAt(index))
                break;
        }

        return min.substring(0, index);
    }

}
