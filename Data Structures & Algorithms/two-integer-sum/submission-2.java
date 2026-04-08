class Solution {
    public int[] twoSum(int[] nums, int target) {
 Map<Integer, Integer> valueToIndex = new HashMap<>(); // value → index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (valueToIndex.containsKey(complement)) {
                int j = valueToIndex.get(complement);
                return new int[] {Math.min(i, j), Math.max(i, j)};
            }

            valueToIndex.put(nums[i], i);
        }

        // This line should never be reached because the problem guarantees one solution
        throw new IllegalArgumentException("No valid pair found");
    }
}