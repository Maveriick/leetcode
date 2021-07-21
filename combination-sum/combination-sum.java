class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, new ArrayList<>(), 0, 0);
        return sol;
    }
    
    private void backTrack(int[] candidates, int target, List<Integer> currentList, int currentSum, int start) {
        if(currentSum == target) {
            sol.add(new ArrayList<>(currentList));
        }
        
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] + currentSum <= target){
                currentList.add(candidates[i]);
                backTrack(candidates, target, currentList, currentSum + candidates[i], i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}