class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0; i<n;i++){
            Arrays.fill(board[i], '.');
        }
        backtracking(0, board, res);
        return res;
    }

   private void backtracking(int row, char[][] board, List<List<String>> res){
    if(row==board.length){
        res.add(constructBoard(board));
        return;
    }

    for(int col =0; col < board.length; col++){
        if(isValid(board, row, col)){
            board[row][col]='Q';
            backtracking(row+1, board, res);
            board[row][col]='.';
        }

    }
   }

   private boolean isValid(char[][] board, int row, int col){
    for(int i=0; i<row; i++){
        if(board[i][col]=='Q') return false;
    }

    for(int i = row-1, j=col-1; i>=0 && j>=0; i--, j--){
        if(board[i][j]=='Q') return false;
    }

       for(int i = row-1, j=col+1; i>=0 && j<board.length; i--, j++){
        if(board[i][j]=='Q') return false;
    }

    return true;
   }

   private List<String> constructBoard(char[][] board){
    List<String> res = new ArrayList<>();
    for(char[] row: board){
         res.add(new String(row));
    }

    return res;
   }
}
