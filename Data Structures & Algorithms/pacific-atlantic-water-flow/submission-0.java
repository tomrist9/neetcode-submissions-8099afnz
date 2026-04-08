class Solution {
    int[][] heights;
    int rows, cols;
    private static final int[][] DIRS = {
        {0,1},
        {0, -1},
        {-1, 0},
        {1,0}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       List<List<Integer>> result = new ArrayList<>();
       if(heights == null || heights.length ==0){
        return null;
       }
       this.heights = heights;
       rows= heights.length;
       cols = heights[0].length;

       boolean[][] pasific = new boolean[rows][cols];
       boolean[][] atlantic = new boolean[rows][cols];

       for(int c =0; c<cols; c++){
        dfs(0, c, pasific);
       }

       for(int r =0; r<rows; r++){
        dfs(r, 0, pasific);
       }

       for(int c=0; c<cols; c++){
        dfs(rows-1, c, atlantic);
       }

       for(int r =0;r<rows;r++){
        dfs(r, cols-1, atlantic);
       }

       for(int c =0; c<cols; c++){
        for(int r =0;r<rows; r++){
            if(pasific[r][c] && atlantic[r][c]){
               result.add(Arrays.asList(r, c));

            }
        }
       }

       return result;
    }

    private void dfs(int r , int c, boolean[][] ocean){
        if(ocean[r][c]) return;
        ocean[r][c]=true;

        for(int[]d : DIRS){
            int nr = r+ d[0];
            int nc = c + d[1];

            if(nr<0 || nr>= rows || nc < 0 || nc>= cols){
               continue;
            }
            if(heights[nr][nc]>= heights[r][c]){
                 dfs(nr, nc, ocean);
            }
        }
    }
} 
