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

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i); // check for pallindromes like aba
            String even = expandFromCenter(s, i, i + 1); // check for pallindromes like abba

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }
        return maxStr;
    }

    private static String expandFromCenter(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        return str.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        String str = "babad";
        String s = longestPalindrome(str);
        System.out.println("Longest palindromic substring is : " + s);
    }
}
