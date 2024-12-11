package dynamicprogram;

/**
 * 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MediumMinPathSum {

    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minRoute = i - 1 >= 0 && j - 1 >= 0 ?
                        Math.min(flag[i - 1][j], flag[i][j - 1]) :
                        i - 1 >= 0 ? flag[i - 1][j] :
                                j - 1 >= 0 ? flag[i][j - 1] : 0;
                flag[i][j] = minRoute + grid[i][j];
            }
        }
        return flag[m-1][n-1];
    }

}
