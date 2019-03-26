package backtracking;

/**
 * Word Search
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class MediumExist {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() < 1) return true;
        int r = board.length;
        if (r < 1) return false;
        int c = board[0].length;
        if (c < 1) return false;
        boolean[][] use = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (find(board, use, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(char[][] board, boolean[][] use, int i, int j, int index, String word) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || use[i][j]) {
            return false;
        }
        use[i][j] = true;
        boolean res = find(board, use, i - 1, j, index + 1, word) ||
                find(board, use, i, j - 1, index + 1, word) ||
                find(board, use, i + 1, j, index + 1, word) ||
                find(board, use, i, j + 1, index + 1, word);
        if (!res) use[i][j] = false;
        return res;
    }
}
