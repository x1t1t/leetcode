package arrayandstring;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 */
public class EasyFirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        //idea I
//        Map<Character, Integer> map = new HashMap();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                int v = map.get(s.charAt(i));
//                map.put(s.charAt(i), ++v);
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//        map = map.entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        if (map.size() <= 0) {
//            return -1;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i)))
//                return i;
//        }
//        return -1;

        //idea II
        char[] c = new char[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (c[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
