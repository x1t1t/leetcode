package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Counting Elements
 * <p>
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them seperately.
 */
public class EasyCountElements {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2};
        System.out.println(countElements(arr));
    }

    public static int countElements(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : arr) {
            countMap.put(a, countMap.containsKey(a) ? countMap.get(a) + 1 : 1);
        }
        int count = 0;
        for (int a : countMap.keySet()) {
            count += (countMap.containsKey(a + 1) ? countMap.get(a) : 0);
        }
        return count;
    }
}
