class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start recursion from row 0
        backtrack(board, 0, solutions);
        return solutions;
    }

    private void backtrack(char[][] board, int row, List<List<String>> solutions) {
        int n = board.length;

        // Base case: if row == n, we found a valid solution
        if (row == n) {
            solutions.add(construct(board));
            return;
        }

        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';  // place queen
                backtrack(board, row + 1, solutions); // recurse
                board[row][col] = '.';  // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
