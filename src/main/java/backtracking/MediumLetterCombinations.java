package backtracking;

import java.util.*;

/**
 * Number of Islands
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class MediumLetterCombinations {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("23").toArray()));
    }

    private static Map<Integer, String> map = new HashMap();

    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        buildList(digits, new StringBuilder(), list);
        return list;
    }

    private static void buildList(String digits, StringBuilder stringBuilder, List<String> list) {
        if (digits.isEmpty()) {
            list.add(stringBuilder.toString());
            return;
        }
        String value = map.get(digits.charAt(0) - '0');
        for (int i = 0; i < value.length(); i++) {
            stringBuilder.append(value.charAt(i));
            buildList(digits.substring(1, digits.length()), stringBuilder, list);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
