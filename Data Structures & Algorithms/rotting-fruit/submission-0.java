class Solution {
        private static final int[][] DIRS = {
        {1,0},
        {-1, 0},
        {0, 1},
        {0, -1}};
    public int orangesRotting(int[][] grid) {
        int minute =0;
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh =0;
        for(int i = 0; i< grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                   queue.offer(new int[]{i, j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty() && fresh >0){
            int size = queue.size();
             minute++;
             for(int f =0; f < size; f++){
            int [] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[]d : DIRS){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr<grid.length && nc>=0 && nc < grid[0].length && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;

                    queue.offer(new int[]{nr, nc});
                }
            }
             }

        }
        return fresh==0? minute : -1;
    }
}
