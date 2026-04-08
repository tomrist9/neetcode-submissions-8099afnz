class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int rows= matrix.length, cols = matrix[0].length;
      int top =0;
      int bottom = rows-1;

      while(top<=bottom){
      int mid = top + (bottom - top)/2;

      if(target > matrix[mid][cols-1]){
        top = mid+1;
      }else if (target < matrix[mid][0]){
        bottom = mid -1;
      }else{
        int left =0;
        int right = cols-1;
        while(left <=right){
            int m = left + (right - left)/2;

            if(target == matrix[mid][m]) return true;
            else if(target > matrix[mid][m]) left = m+1;
            else right = m-1;
        }
        return false;
      }
      }
return false;

    }
}
