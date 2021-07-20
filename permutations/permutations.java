class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<>());
        return sol;
    }
    
    private void permute(int[] nums, List<Integer> currentList) {
        if(currentList.size() == nums.length) {
            sol.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!currentList.contains(nums[i])) {
                currentList.add(nums[i]);
                permute(nums, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}