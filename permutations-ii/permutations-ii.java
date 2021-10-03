class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new ArrayList<>(), new HashSet<>());
        return solution;
    }
    
    private void permute(int[] nums, List<Integer> currentList, Set<Integer> visited) {
        if(currentList.size() == nums.length){
            solution.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited.contains(i) || i > 0 && nums[i] == nums[i-1] && !visited.contains(i-1)){
                continue;
            }
            currentList.add(nums[i]);
            visited.add(i);
            permute(nums, currentList, visited);
            visited.remove(i);
            currentList.remove(currentList.size() - 1);
            
        }
    }
}