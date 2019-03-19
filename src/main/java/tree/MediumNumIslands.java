package tree;

/**
 * Number of Islands
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */
public class MediumNumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int count = 0, r = grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dsf(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dsf(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dsf(grid, i - 1, j);
        dsf(grid, i + 1, j);
        dsf(grid, i, j - 1);
        dsf(grid, i, j + 1);
    }
}
