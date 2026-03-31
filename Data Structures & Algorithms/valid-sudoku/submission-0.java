class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') continue;
                
                char num = board[i][j];
                
                String rowKey = num + "_row_" + i;
                String colKey = num + "_col_" + j;
                String boxKey = num + "_box_" + (i / 3) + "_" + (j / 3);
                
                if (set.contains(rowKey) || 
                    set.contains(colKey) || 
                    set.contains(boxKey)) {
                    return false;
                }
                
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }
        
        return true;
    }
}