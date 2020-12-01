package queue;

import java.util.*;

/**
 * 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }

    public static int[] dailyTemperatures(int[] T) {

        /** idea I */
//        int[] a = new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            int j = i + 1, num = 0;
//            while (j < T.length) {
//                num++;
//                if (T[j] > T[i]) {
//                    break;
//                }
//                if (j == T.length - 1) {
//                    num = 0;
//                }
//                j++;
//            }
//            a[i] = num;
//        }
//        return a;


        /** idea II */
//        int[] a = new int[T.length];
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(T[T.length - 1], T.length - 1);
//        for (int i = T.length - 2; i >= 0; i--) {
//            int num = Integer.MAX_VALUE;
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                if (entry.getKey() > T[i]) {
//                    num = Math.min(num, entry.getValue() - i);
//                }
//            }
//            map.put(T[i], i);
//            a[i] = Objects.equals(num, Integer.MAX_VALUE) ? 0 : num;
//        }
//        return a;

        /** idea III */
        int[] a = new int[T.length];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!queue.isEmpty() && T[i] > T[queue.peek()]) {
                int p = queue.pop();
                a[p] = i - p;
            }
            queue.push(i);
        }
        return a;

    }
}
