package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class HardSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
//                {13, 14, 15, 16},
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        if (r < 1) return new ArrayList<>();
        int c = matrix[0].length;
        if (c < 1) return new ArrayList<>();
        boolean[][] flag = new boolean[r][c];
        List<Integer> result = new ArrayList<>();
        dsf(matrix, flag, 0, 0, result);
        return result;
    }

    private static void dsf(int[][] matrix, boolean[][] flag, int i, int j, List<Integer> result) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        result.add(matrix[i][j]);
        boolean condition1 = (j - 1 < 0 || flag[i][j - 1]) && (j + 1 < matrix[0].length && !flag[i][j + 1]);
        boolean condition2 = (i - 1 < 0 || flag[i - 1][j]) && (i + 1 < matrix.length && !flag[i + 1][j]);
        boolean condition3 = (j + 1 >= matrix[0].length || flag[i][j + 1]) && (j - 1 >= 0 && !flag[i][j - 1]);
        boolean condition4 = (i + 1 >= matrix.length || flag[i + 1][j]) && (i - 1 >= 0 && !flag[i - 1][j]);
        if (condition1 && condition4) {
            dsf(matrix, flag, i - 1, j, result);
        } else if (condition1) {
            dsf(matrix, flag, i, j + 1, result);
        } else if (condition2) {
            dsf(matrix, flag, i + 1, j, result);
        } else if (condition3) {
            dsf(matrix, flag, i, j - 1, result);
        } else {
            dsf(matrix, flag, i - 1, j, result);
        }
    }
}
