class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right = heights.length -1;
        int mostWater =0;

        while(left<right){
            int width = right -left;
            int containerHeight = Math.min(heights[left], heights[right]);

            int water = width * containerHeight;

            mostWater = Math.max(mostWater, water);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right --;
            }
        }
        return mostWater;
    }
}
