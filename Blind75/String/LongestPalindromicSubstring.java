package Blind75.String;

/**
 * Given a string s, return the longest palindromic substring in s. A string is palindromic if it reads the same
 * forward and backward. A substring is a contiguous non-empty sequence of characters within a string.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * Input: s = "babad" <br>
 * Output: "bab" <br>
 * Explanation: "aba" is also a valid answer.
 * <p>
 * <b>Example 2:</b>
 * <p>
 * Input: s = "cbbd" <br>
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    static int resultStart;
    static int resultLength;

    public static String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() &&
                str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;

        }
    }

    public static void main(String[] args) {
        String str = "babad";
        String s = LongestPalindromicSubstring.longestPalindrome(str);
        System.out.println("Longest palindromic substring is : " + s);
    }
}
