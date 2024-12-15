package dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串。返回 s 所有可能的分割方案。
 */
public class MediumPartition {

    public static void main(String[] args) {
        System.out.println(partition("mmmmm"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> partLists = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            subPartition(s, partLists, i, i, i);
        }
        List<List<String>> lists = new ArrayList<>();
        dfs(lists, partLists, new ArrayList<>(), 0, s.length());
        return lists;
    }

    public static void subPartition(String s, List<List<String>> partLists, int index, int left, int right) {
        if (left == index && right == index) {
            List<String> list = new ArrayList<>();
            String s1 = String.valueOf(s.charAt(index));
            list.add(s1);
            partLists.add(list);
            if (index + 1 < s.length()) {
                subPartition(s, partLists, index, left, right + 1);
            }
            if (index - 1 >= 0 && index + 1 < s.length()) {
                subPartition(s, partLists, index, left - 1, right + 1);
            }
        } else if (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                String s1 = s.substring(left, right + 1);
                partLists.get(left).add(s1);
                if (left - 1 >= 0 && right + 1 < s.length()) {
                    subPartition(s, partLists, index, left - 1, right + 1);
                }
            }
        }
    }

    public static void dfs(List<List<String>> lists, List<List<String>> partLists, List<String> list, int index, int length) {
        List<String> partList = partLists.get(index);
        for (int i = 0; i < partList.size(); i++) {
            String subP = partList.get(i);
            List<String> list1 = new ArrayList<>(list);
            list1.add(subP);
            if (index + subP.length() == length) {
                lists.add(list1);
            } else {
                dfs(lists, partLists, list1, index + subP.length(), length);
            }
        }
    }

}
