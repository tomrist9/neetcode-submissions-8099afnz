class Solution {
    private static final int INF= 2147483647;
    private static final int[][] DIRS = {
        {1,0},
        {-1, 0},
        {0, 1},
        {0, -1}};
    
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int [] cell = queue.poll();
            int r =cell[0];
            int c = cell[1];

            for(int[]d : DIRS){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<grid.length &&
                nc>=0 && nc<grid[0].length &&
                grid[nr][nc]==INF){
                    grid[nr][nc]= grid[r][c]+1;

                    queue.offer(new int[]{nr,nc});
                }

            }
        }
    }
}
