package hard;

import java.util.regex.Pattern;

/**
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * \s*      所有空白符
 * [+-]?    一个正负号
 * (\d+\.?\d*|\.\d+)    小数点开头或者不是小数点开头
 * (e[+-]?\d+)  e       exx
 * \s*      空白符
 *
 */
public class ValidNumber {

    private static String pattern = "^\\s*[+-]?(\\d+\\.?\\d*|\\.\\d+)(e[+-]?\\d+)?\\s*$";

    /**
     * 正则表达式方式，速度很慢
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        return Pattern.matches(pattern,s);
    }

}
