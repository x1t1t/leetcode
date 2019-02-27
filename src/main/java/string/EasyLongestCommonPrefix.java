package string;

/**
 * Longest Common Prefix
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class EasyLongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (String s : strs) {
            if (str.length() == 0) {
                return "";
            }
            int f = Math.min(str.length(), s.length());
            for (int i = 0; i < f; i++) {
                if (s.charAt(i) != str.charAt(i)) {
                    f = i;
                }
            }
            str = str.substring(0, f);
        }
        return str;
    }
}
