package array;

import java.util.*;

/**
 * Group Anagrams
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class MediumGroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> list : groupAnagrams(strs)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        /** ideaI
        boolean f = true;
        for (int i = 0; i < strs.length; i++) {
            for (List<String> list : lists) {
                if (isSame(list.get(0), strs[i])) {
                    list.add(strs[i]);
                    f = false;
                }
            }
            if (f) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
            }
            f = true;
        }
        return lists;  */

        /**ideaII*/
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            if (map.containsKey(Arrays.toString(cs))) {
                map.get(Arrays.toString(cs)).add(s);
            } else {
                List list = new ArrayList();
                Collections.addAll(list, s);
                map.put(Arrays.toString(cs), list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static boolean isSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Ch = s1.toCharArray();
        char[] s2Ch = s2.toCharArray();
        Arrays.sort(s1Ch);
        Arrays.sort(s2Ch);
        for (int i = 0; i < s1Ch.length; i++) {
            if (s1Ch[i] != s2Ch[i]) {
                return false;
            }
        }
        return true;
    }
}
