class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new ArrayList<>());
        return sol;
    }
    
    
    private void backTrack(int[] nums, List<Integer> currentList) {
        if(currentList.size() == nums.length) {
            sol.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!currentList.contains(nums[i])) {
                currentList.add(nums[i]);
                backTrack(nums, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}