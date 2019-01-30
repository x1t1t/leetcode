package arrayandstring;

import java.util.*;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class EasyIsValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        Map<Character, List<List<Integer>>> boardMap = new HashMap();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                if (boardMap.containsKey(board[i][j])) {
                    List<List<Integer>> listList = boardMap.get(board[i][j]);
                    for (List<Integer> lists : listList) {
                        if (lists.get(0) == i || lists.get(1) == j ||
                                (i / 3 == lists.get(0) / 3 && j / 3 == lists.get(1) / 3)) {
                            return false;
                        }
                    }
                    List<Integer> l = new ArrayList();
                    Collections.addAll(l, i, j);
                    listList.add(l);
                } else {
                    List<Integer> l = new ArrayList();
                    Collections.addAll(l, i, j);
                    List<List<Integer>> ll = new ArrayList<>();
                    Collections.addAll(ll, l);
                    boardMap.put(board[i][j], ll);
                }
            }
        }
        return true;
    }
}
