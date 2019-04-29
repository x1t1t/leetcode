package array;

import java.util.Arrays;

/**
 * Game of Life
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 */
public class HardGameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void gameOfLife(int[][] board) {
        int r = board.length;
        if (r < 1) {
            return;
        }
        int c = board[0].length;
        if (c < 1) {
            return;
        }
        boolean[][] record = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                handle(board, i, j, record);
            }
        }
    }

    private static void handle(int[][] board, int i, int j, boolean[][] record) {
        int aliveCount = alive(board, i - 1, j - 1, record) + alive(board, i - 1, j, record) +
                alive(board, i - 1, j + 1, record) + alive(board, i, j - 1, record) +
                alive(board, i, j + 1, record) + alive(board, i + 1, j - 1, record) +
                alive(board, i + 1, j, record) + alive(board, i + 1, j + 1, record);
        if (board[i][j] == 1) {
            if (aliveCount < 2 || aliveCount > 3) {
                board[i][j] = 0;
                record[i][j] = true;
            }
        } else {
            if (aliveCount == 3) {
                board[i][j] = 1;
                record[i][j] = true;
            }
        }
    }

    private static int alive(int[][] board, int i, int j, boolean[][] record) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        }
        if ((board[i][j] == 1 && !record[i][j]) || (board[i][j] == 0) && record[i][j]) {
            return 1;
        }
        return 0;
    }
}
