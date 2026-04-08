class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> path) {

        result.add(new ArrayList<>(path));


        for (int i = start; i < nums.length; i++) {
             if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(i + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }
}