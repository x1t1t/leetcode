package string;

/**
 * Valid Palindrome
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class EasyIsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            if (!validChar(s.charAt(begin))) {
                begin++;
                continue;
            }
            if (!validChar(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(begin)) == Character.toLowerCase(s.charAt(end))) {
                begin++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean validChar(char ch) {
        return (ch - 'a' >= 0 && ch - 'z' <= 0) ||
                (ch - 'A' >= 0 && ch - 'Z' <= 0) ||
                (ch - '0' >= 0 && ch - '9' <= 0);
    }
}
