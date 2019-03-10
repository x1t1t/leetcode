package string;

/**
 * Longest Palindromic Substring
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class MediumLongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        String str = s.substring(0, 1);
        for (int i = 1; i < len; i++) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder(String.valueOf(s.charAt(i)));
            int begin = i - 1, end = i;
            while (begin >= 0 && end < len && s.charAt(begin) == s.charAt(end)) {
                s1 = new StringBuilder(s.charAt(begin) + s1.toString() + s.charAt(end));
                begin--;
                end++;
            }
            begin = i - 1;
            end = i + 1;
            while (begin >= 0 && end < len && s.charAt(begin) == s.charAt(end)) {
                s2 = new StringBuilder(s.charAt(begin) + s2.toString() + s.charAt(end));
                begin--;
                end++;
            }
            String s3 = s1.toString().length() > s2.toString().length() ? s1.toString() : s2.toString();
            str = str.length() > s3.length() ? str : s3;
        }
        return str;
    }
}
