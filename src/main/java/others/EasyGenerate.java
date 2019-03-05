package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class EasyGenerate {
    public static void main(String[] args) {
        for (List<Integer> list : generate(5)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0, 1);
            if (i > 0) {
                List<Integer> list1 = lists.get(i - 1);
                for (int j = 1; j < i; j++) {
                    list.add(list1.get(j - 1) + list1.get(j));
                }
                list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }
}
