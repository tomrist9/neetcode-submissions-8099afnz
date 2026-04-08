class Solution {


     int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
     
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
       
        int[][] dp = new int[n][m];
        int max =0;

        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                max=Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    private int dfs(int[][]matrix,int i, int j,int[][]dp){
        if(dp[i][j]!=0) return dp[i][j];
        int max=1;
        for(int[]d : dir){
            int ni= i+ d[0];
            int nj=j+d[1];

            if(ni>=0 && nj>=0 && ni<matrix.length && nj<matrix[0].length && matrix[ni][nj]>matrix[i][j]){
                max=Math.max(max, 1+dfs(matrix, ni, nj, dp));
            }
        }
        dp[i][j]=max;
        return max;
    }
}
