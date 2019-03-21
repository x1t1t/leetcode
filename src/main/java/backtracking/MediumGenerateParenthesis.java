package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate Parentheses
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class MediumGenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }


    public static List<String> generateParenthesis(int n) {
        if (n < 1) return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        dsf(sb, list, 0, 0, n);
        return list;
    }

    private static void dsf(StringBuilder sb, List<String> list, int left, int right, int n) {
        if (left == n && right == n) {
            list.add(sb.toString());
            return;
        }
        if (left <= right) {
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append("(");
            dsf(sb1, list, ++left, right, n);
        } else if (left == n) {
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append(")");
            dsf(sb1, list, left, ++right, n);
        } else {
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append("(");
            dsf(sb1, list, ++left, right, n);
            StringBuilder sb2 = new StringBuilder(sb);
            sb2.append(")");
            dsf(sb2, list, --left, ++right, n);
        }
    }

}
