class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int n = grid.length;
        boolean [][] visited = new boolean[n][n];

        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};

       while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];

            if(visited[x][y]) continue;
            visited[x][y]=true;
            if(x==n-1 && y== n-1){
                return time;
            }

            for(int[] dir : dirs){
                int nx= x+dir[0];
                int ny = y+dir[1];

                if(nx>=0 && nx < n && ny>=0 && ny<n && !visited[nx][ny]){
                    int newTime = Math.max(time, grid[nx][ny]);
                    pq.offer(new int[]{newTime, nx, ny});
                }
        }
       }
       return -1;
    }
}
