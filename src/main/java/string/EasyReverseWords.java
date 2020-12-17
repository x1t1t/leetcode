package string;

import java.util.List;

/**
 * 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class EasyReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {

        //ideaI
        String[] strings = s.split(" ");
        String rs = "";
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("")) {
                continue;
            }
            if (i != 0) {
                rs += " ";
            }
            String str = strings[i];
            for (int j = str.length() - 1; j >= 0; j--) {
                rs += str.charAt(j);
            }
        }
        return rs;

    }

}
