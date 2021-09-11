package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 */
public class MediumIntervalIntersection {

    public static void main(String[] args) {
        int[][] firstList = {{14,16}};
        int[][] secondList = {{7,13},{16,20}};
        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fl = firstList.length, sl = secondList.length, i = 0, j = 0;
        if (fl == 0 || sl == 0) return new int[0][0];
        List<Integer> list = new ArrayList<>();
        while (i < fl && j < sl) {
            if (firstList[i][1] < secondList[j][0]) {
                i++;
            } else if (firstList[i][0] > secondList[j][1]) {
                j++;
            } else {
                list.add(Math.max(firstList[i][0], secondList[j][0]));
                list.add(Math.min(firstList[i][1], secondList[j][1]));
                if (firstList[i][1] > secondList[j][1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        int[][] rel = new int[list.size() / 2][2];
        for (int k = 0; k < list.size(); k += 2) {
            rel[k / 2][0] = list.get(k);
            rel[k / 2][1] = list.get(k + 1);
        }
        return rel;
    }
}
