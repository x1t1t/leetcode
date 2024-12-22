package array;

import java.util.*;

/**
 * 1387. 将整数按权重排序
 * <p>
 * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 * <p>
 * 如果 x 是偶数，那么 x = x / 2
 * 如果 x 是奇数，那么 x = 3 * x + 1
 * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 * <p>
 * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 * <p>
 * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 * <p>
 * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
 */
public class MediumGetKth {

    public static void main(String[] args) {
        System.out.println(getKth(7, 11, 4));
    }

    public static int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(1, 0);
        for (int i = 2; i <= hi; i++) {
            fillDp(dpMap, i, i, 0);
        }
        int[] array = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            array[i - lo] = i;
        }
        quickSort(array, dpMap, 0, hi - lo);
        int value = dpMap.get(array[k - 1]);
        int l = k - 2, r = k, th = k - 1;
        List<Integer> list = new ArrayList<>();
        list.add(array[k - 1]);
        while (l >= 0 || r <= hi - lo) {
            if (l >= 0 && dpMap.get(array[l]) == value) {
                list.add(array[l]);
                th = l;
                l--;
            } else {
                l = -1;
            }
            if (r <= hi - lo && dpMap.get(array[r]) == value) {
                list.add(array[r]);
                r++;
            } else {
                r = hi + 1;
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list.get(k - 1 - th);
    }

    private static void fillDp(Map<Integer, Integer> dpMap, int index, int flag, Integer step) {
        Integer count = dpMap.get(flag);
        if (count != null) {
            dpMap.put(index, step + count);
        } else {
            step += 1;
            if (flag % 2 == 1) {
                fillDp(dpMap, index, flag * 3 + 1, step);
            } else {
                fillDp(dpMap, index, flag / 2, step);
            }
        }
    }

    private static void quickSort(int[] array, Map<Integer, Integer> dpMap, int l, int r) {
        if (l >= r) {
            return;
        }
        int point = findPoint(array, dpMap, l, r);
        quickSort(array, dpMap, l, point - 1);
        quickSort(array, dpMap, point + 1, r);
    }

    private static int findPoint(int[] array, Map<Integer, Integer> dpMap, int l, int r) {
        int base = dpMap.get(array[l]);
        int s = l, e = r;
        while (s < e) {
            while (s < e && dpMap.get(array[e]) > base) {
                e--;
            }
            while (s < e && base >= dpMap.get(array[s])) {
                s++;
            }
            swap(array, s, e);
        }
        swap(array, l, e);
        return e;
    }

    private static void swap(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int key = array[l];
        array[l] = array[r];
        array[r] = key;
    }

}
