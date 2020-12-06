package array;

import java.util.Arrays;

/**
 * 对角线遍历
 * <p>
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素
 */
public class MediumFindDiagonalOrder {

    public static void main(String[] args) {

                int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));

    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length==0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length, i = 0, j = 0, k = 0;
        int[] num = new int[m * n];
        while (i < m && j < n) {
            num[k++] = matrix[i][j];
            if (i == m - 1 && j == n - 1) {
                break;
            } else if ((i + j) % 2 == 0) {
                if (j == n - 1) {
                    i++;
                } else {
                    i = Math.max(i - 1, 0);
                    j = Math.min(j + 1, n - 1);
                }
            } else {
                if (i == m - 1) {
                    j++;
                } else {
                    i = Math.min(i + 1, m - 1);
                    j = Math.max(j - 1, 0);
                }
            }
        }
        return num;
    }

}
