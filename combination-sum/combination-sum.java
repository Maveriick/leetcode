class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, 0, new ArrayList<>());
        return solution;
    }
    
    private void backTrack(int[] candidates, int target, int currentIndex, int currentSum, List<Integer> currentList) {
        if(currentSum == target) {
            solution.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = currentIndex; i < candidates.length; i++) {
            if(currentSum + candidates[i] <= target){
                currentList.add(candidates[i]);
                backTrack(candidates, target, i, currentSum + candidates[i], currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
        
    }
}