package string;

/**
 * 翻转字符串里的单词
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class MediumReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords(" asdf asd  ffd "));
    }

    public static String reverseWords(String s) {

        //ideaI
        String[] strings = s.split(" ");
        String rs = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            if (i != strings.length - 1) {
                rs += " ";
            }
            rs += strings[i];
        }
        return rs;

    }
}
