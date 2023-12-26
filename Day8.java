1. Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                if (!seen.add(board[r][c] + "in row" + r) ||
                    !seen.add(board[r][c] + "in col" + c) ||
                    !seen.add(board[r][c] + "in block" + r/3 + c/3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
