import java.util.*;

class Solution {
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        int[][] board = new int[n][n];

        // Initialize board with -1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = -1;

        board[0][0] = 0; // start position

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (solve(0, 0, 1, board, n)) {
            // convert int[][] → ArrayList<ArrayList<Integer>>
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(board[i][j]);
                }
                res.add(row);
            }
        }
        return res;
    }

    static boolean solve(int x, int y, int move, int[][] board, int n) {
        if (move == n * n)
            return true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(nextX, nextY, board, n)) {
                board[nextX][nextY] = move;
                if (solve(nextX, nextY, move + 1, board, n))
                    return true;
                board[nextX][nextY] = -1; // backtrack
            }
        }
        return false;
    }

    static boolean isValid(int x, int y, int[][] board, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
}
