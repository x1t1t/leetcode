package sortandsearch;

import java.util.*;

/**
 * Top K Frequent Elements
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class MediumTopKFrequent {
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length < 1) return new ArrayList<>();
        /**ideaI
        Arrays.sort(nums);
        List<NumTop> list = new ArrayList<>();
        for (int num : nums) {
            if (list.size() < 1) {
                list.add(new NumTop(num, 1));
            } else {
                if (list.get(list.size() - 1).num == num) {
                    list.get(list.size() - 1).count += 1;
                } else {
                    list.add(new NumTop(num, 1));
                }
            }
        }
        Collections.sort(list, (a, b) -> b.count - a.count);
        return list.stream().map(numTop -> numTop.num).limit(k).collect(Collectors.toList());*/

        /**ideaII */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map1.containsKey(entry.getValue())) {
                map1.get(entry.getValue()).add(entry.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                map1.put(entry.getValue(), list);
            }
            if (set.size() < k) {
                set.add(entry.getValue());
            } else {
                if (entry.getValue() > set.iterator().next()) {
                    set.remove(set.iterator().next());
                    set.add(entry.getValue());
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int s : set) {
            list1.add(0, s);
        }
        for (int s : list1) {
            if (list.size() + map1.get(s).size() > k) {
                list.addAll(map1.get(s).subList(0, k - list.size()));
                break;
            }
            list.addAll(map1.get(s));
        }
        return list;
    }

    static class NumTop {
        int num;
        int count;

        public NumTop(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
