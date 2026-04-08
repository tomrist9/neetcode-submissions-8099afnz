class Solution {
    public int rob(int[] nums) {
        int prev1=0;
        int prev2=0;
      int max=0;
        for(int num : nums){
         max = Math.max(prev1, prev2+num);
         prev2=prev1;
         prev1=max;
        }

        return Math.max(prev1, prev2);
    }
}
