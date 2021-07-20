class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>());
        return sol;
    }
    
    private void subsets(int[] nums, int index, List<Integer> currentSet) {
        sol.add(new ArrayList<Integer>(currentSet));
        
        for(int i = index; i < nums.length; i++) {
            if( i > index && nums[i] == nums[i-1]){
                continue;
            }
            currentSet.add(nums[i]);
            subsets(nums, i + 1, currentSet);
            currentSet.remove(currentSet.size() - 1);
            
        }
    }
}