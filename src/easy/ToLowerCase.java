package easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * emmm... 回来太晚了并且电脑一直重启所以时间只够码这么一个东西了。。。
 * Implement function ToLowerCase() that has a string parameter str,
 * and returns the same string in lowercase.
 */
public class ToLowerCase {
    private int diff = 'a' - 'A';
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            cs[i] = cs[i] >= 'A' && cs[i] <= 'Z' ? (char)(cs[i] + diff) : cs[i];
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("AAAAAAsfd"));
    }

}
