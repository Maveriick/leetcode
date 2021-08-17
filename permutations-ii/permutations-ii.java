class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return solution;
    }
    
    
    private void backTrack(int[] nums, List<Integer> currentList, boolean[] visited) {
        if(currentList.size() == nums.length) {
            solution.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == true || i > 0 && nums[i-1] == nums[i] && visited[i-1] == true){
                continue;
            }
        
            currentList.add(nums[i]);
            visited[i] = true;
            backTrack(nums, currentList, visited);
            currentList.remove(currentList.size() - 1);
            visited[i] = false;
        }
    }
}