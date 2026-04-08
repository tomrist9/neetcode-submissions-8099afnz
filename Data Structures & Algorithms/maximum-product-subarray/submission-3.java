class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int result=nums[0];

        for(int i=1; i<nums.length; i++){
       
                        int tempMax = Math.max(nums[i],
                    Math.max(nums[i] * currentMax, nums[i] * currentMin));

            currentMin = Math.min(nums[i],
                    Math.min(nums[i] * currentMax, nums[i] * currentMin));

            currentMax = tempMax;

            result = Math.max(result, currentMax);

        }

        return result;
    }
}
