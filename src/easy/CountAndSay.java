package easy;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {

    private StringBuilder result;
    private static ArrayList<String> strs = new ArrayList<>();

    static {
        strs.add("1");
    }

    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (strs.size() >= n) return strs.get(n-1);
        while (strs.size() < n){
            String current = strs.get(strs.size() - 1);
            char tmp = current.charAt(0);
            int times = 1;
            result = new StringBuilder();
            for (int i = 1; i < current.length(); i++) {
                if (tmp == current.charAt(i)) times++;
                else {
                    result.append(times);
                    result.append(tmp);
                    tmp = current.charAt(i);
                    times = 1;
                }
            }
            result.append(times);
            result.append(tmp);
            strs.add(result.toString());
        }
        return strs.get(n-1);
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        for (int i = 0; i < 10; i++) {
            System.out.println(c.countAndSay(i));
        }
    }

}
