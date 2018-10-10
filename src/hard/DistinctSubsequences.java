package hard;

/**
 * 动态规划，先看s可以获得多少个t[0], 然后据此获得t[0...1], 然后t[0...2], ...
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Example 1:
 * <p>
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * <p>
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * <p>
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 * <p>
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * <p>
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * <p>
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 */
public class DistinctSubsequences {

    /*  time out
        private char[] s;
        private char[] t;

        public int numDistinct(String s, String t) {
            this.s = s.toCharArray();
            this.t = t.toCharArray();
            return numDistinctOf(0, 0);
        }

        private int numDistinctOf(int indexOfS, int indexOfT){
            if (indexOfT >= t.length) return 1;
            if (indexOfS >= s.length) return 0;
            int sum = 0;
            for (int i = indexOfS; i < s.length; i++) {
                if (s[i] == t[indexOfT])
                    sum += numDistinctOf(i + 1, indexOfT + 1);
            }
            return sum;
        }
        */
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[][] tmp = new int[t.length()][s.length()];
        char c = t.charAt(0);
        tmp[0][0] = c == s.charAt(0) ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            tmp[0][i] = tmp[0][i-1] + (s.charAt(i) == c ? 1 : 0);
        }
        for (int i = 1; i < t.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                tmp[i][j] = tmp[i][j - 1] + (s.charAt(j) == t.charAt(i) ? tmp[i - 1][j - 1] : 0);
            }
        }
        return tmp[t.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
    }

/*
The idea is the following:

we will build an array mem where mem[i+1][j+1] means that S[0..j] contains T[0..i] that many times as distinct subsequences. Therefor the result will be mem[T.length()][S.length()].
we can build this array rows-by-rows:
the first row must be filled with 1. That's because the empty string is a subsequence of any string but only 1 time. So mem[0][j] = 1 for every j. So with this we not only make our lives easier, but we also return correct value if T is an empty string.
the first column of every rows except the first must be 0. This is because an empty string cannot contain a non-empty string as a substring -- the very first item of the array: mem[0][0] = 1, because an empty string contains the empty string 1 time.
So the matrix looks like this:

  S 0123....j
T +----------+
  |1111111111|
0 |0         |
1 |0         |
2 |0         |
. |0         |
. |0         |
i |0         |
From here we can easily fill the whole grid: for each (x, y), we check if S[x] == T[y] we add the previous item and the previous item in the previous row, otherwise we copy the previous item in the same row. The reason is simple:

if the current character in S doesn't equal to current character T, then we have the same number of distinct subsequences as we had without the new character.
if the current character in S equal to the current character T, then the distinct number of subsequences: the number we had before plus the distinct number of subsequences we had with less longer T and less longer S.
An example:
S: [acdabefbc] and T: [ab]

first we check with a:

           *  *
      S = [acdabefbc]
mem[1] = [0111222222]
then we check with ab:

               *  * ]
      S = [acdabefbc]
mem[1] = [0111222222]
mem[2] = [0000022244]
And the result is 4, as the distinct subsequences are:

      S = [a   b    ]
      S = [a      b ]
      S = [   ab    ]
      S = [   a   b ]
 */

}
