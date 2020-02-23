package array;

import java.util.*;

/**
 * 522. Longest Uncommon Subsequence II
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 */
public class MediumFindLUSlength {

    public static void main(String[] args) {
        String[] strs = {"aabbcc", "aabbcc", "abc"};
        System.out.print(findLUSlength(strs));
    }

    public static int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return -1;
        }
        Map<Integer, List<String>> strMap = new HashMap<>();
        Map<String, Integer> strCountMap = new HashMap<>();
        List<Integer> strList = new ArrayList<>();
        for (String str : strs) {
            int len = str.length();
            if (!strList.contains(len)) strList.add(len);
            if (strMap.containsKey(len)) {
                strMap.get(len).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                strMap.put(len, list);
            }
            if (strCountMap.containsKey(str)) {
                int count = strCountMap.get(str);
                strCountMap.put(str, count + 1);
            } else {
                strCountMap.put(str, 1);
            }
        }
        strList.sort((o1, o2) -> o2 - o1);
        String string = "";
        for (int len : strList) {
            List<String> list = strMap.get(len);
            for (String s : list) {
                if (!contains(string, s) && strCountMap.get(s) == 1) {
                    return s.length();
                }
            }
            string = list.get(0);
        }
        return -1;
    }

    private static boolean contains(String string, String s) {
        if (string.length() < s.length()) {
            return false;
        }
        int j = 0;
        for (int i = 0; j < s.length() && i < string.length(); i++) {
            if (s.charAt(j) == string.charAt(i + j))
                j++;
        }
        return j == s.length();
    }
}
