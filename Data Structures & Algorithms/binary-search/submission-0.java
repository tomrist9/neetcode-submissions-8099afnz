class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left =0;  int right = n-1;

        for(int i =0; i<n;i++){
            int mid = left +(right-left)/2;

            if(nums[mid]==target) {
                return mid;
            }else if(nums[mid]<target){
                left++;
            }else{
                right--;
            }
            }
        return -1;
    }
}
