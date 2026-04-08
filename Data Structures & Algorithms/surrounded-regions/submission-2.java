class Solution {
    private static final int [][] DIRS = {
        {0, 1},
        {1, 0},
        {-1, 0},
        {0, -1}
    };

   
    public void solve(char[][] board) {
        if(board == null || board.length==0) return ;
        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

       for(int r = 0; r<rows; r++){
            if(board[r][0]=='O'){
                queue.offer(new int[]{r,0});
                board[r][0]='#';
            }
         if(board[r][cols-1]=='O'){
                board[r][cols-1]='#';
                 queue.offer(new int[]{r,cols-1});
            }

        }

        for(int c=0; c<cols; c++){
                if(board[0][c]=='O'){
                queue.offer(new int[]{0,c});
                board[0][c]='#';
            }
         if(board[rows-1][c]=='O'){
                queue.offer(new int[]{rows-1,c});
                board[rows-1][c]='#';
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : DIRS){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr < rows && nc>=0 && nc<cols && board[nr][nc]=='O'){
                    board[nr][nc]='#';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        for(int r=0; r<rows; r++){
            for(int c =0; c<cols; c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }else if(board[r][c]=='#'){
                    board[r][c]='O';
                }
            }
        }
    }
}
