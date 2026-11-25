
import java.util.*;

class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    boolean[] col;
    boolean[] diagonal1;
    boolean[] diagonal2;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, n);

        return ans;
    }

    void solve(int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (col[c] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            board[row][c] = 'Q';
            col[c] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            solve(row + 1, n);

            board[row][c] = '.';
            col[c] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}
