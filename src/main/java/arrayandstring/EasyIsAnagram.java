package arrayandstring;

/**
 * Valid Anagram
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 */
public class EasyIsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] sc = new int[26];
        if (s.length() != t.length())
            return false;
        for (Character chs : s.toCharArray()) {
            sc[chs - 'a']++;
        }

        for (Character cht : t.toCharArray()) {
            if (--sc[cht - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
