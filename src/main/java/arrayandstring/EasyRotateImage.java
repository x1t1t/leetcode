package arrayandstring;

import java.util.Arrays;

/**
 * Rotate Image
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class EasyRotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length, l = len - 1;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[l - j][i];
                matrix[l - j][i] = matrix[l - i][l - j];
                matrix[l - i][l - j] = matrix[j][l - i];
                matrix[j][l - i] = temp;
            }
        }
    }
}
