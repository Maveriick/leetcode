class Solution {
     List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new ArrayList<>(), new HashSet<>());
        return sol;
    }
    
    private void permute(int[] nums, List<Integer> currentList, Set<Integer> seenIndex) {
        
        if(currentList.size() == nums.length) {
            sol.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(seenIndex.contains(i) || i > 0 && nums[i] == nums[i-1] && seenIndex.contains(i-1) ) continue;

                currentList.add(nums[i]);
                seenIndex.add(i);
                permute(nums, currentList, seenIndex);
                seenIndex.remove(i);
                currentList.remove(currentList.size() - 1); 
            
                         
        }
    }
}