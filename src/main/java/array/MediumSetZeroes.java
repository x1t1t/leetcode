package array;

import java.util.Arrays;

/**
 * Set Matrix Zeroes
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class MediumSetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int r = matrix.length;
        if (r <= 0) return;
        int c = matrix[0].length;
        /** ideaI 空间复杂度O(c)
        boolean[] flag = new boolean[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    flag[j] = true;
                    int k = c - 1;
                    while (k >= 0) {
                        if (matrix[i][k] == 0) {
                            flag[k] = true;
                        }
                        matrix[i][k] = 0;
                        k--;
                    }
                    j = c;
                }
            }
        }
        for (int i = 0; i < c; i++) {
            if (flag[i]) {
                int j = r - 1;
                while (j >= 0) {
                    matrix[j][i] = 0;
                    j--;
                }
            }
        }*/

        /**ideaII 用第一行列来存储0*/
        boolean fr = false, fc = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            while (c > 0) {
                matrix[0][c - 1] = 0;
                c--;
            }
        }
        if (fc) {
            while (r > 0) {
                matrix[r-1][0] = 0;
                r--;
            }
        }
    }
}
