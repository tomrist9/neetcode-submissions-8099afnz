class Solution {
    int ROW, COL;
    
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        Set<String> visited = new HashSet<>();
        for(int r=0; r<ROW; r++){
            for(int c=0; c<COL; c++){
                if(dfs(board, word, r,c, 0, visited)){
                    return true;
                }
            }
        }
         return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, Set<String> visited){
        if(i==word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=ROW || c>=COL){
            return false;
        }

        String key = r +","+c;
        if(visited.contains(key)){
            return false;
        }
  if (board[r][c] != word.charAt(i)) {
            return false;
        }


        visited.add(key);

        boolean found = dfs(board, word,r+1, c, i+1 , visited)||
        dfs(board, word,r-1, c, i+1 , visited)||
        dfs(board, word,r, c+1, i+1 , visited)||
        dfs(board, word,r, c-1, i+1 , visited);

        visited.remove(key);
        return found;
            }
}
