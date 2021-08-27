class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return solution;
    }
    
    private void backtrack(int[] candidates, int target, List<Integer> current, int currentSum, int currentIndex) {
        if(currentSum == target) {
            solution.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = currentIndex; i < candidates.length; i++) {
            if(currentSum + candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(candidates, target, current, currentSum + candidates[i], i);
                current.remove(current.size() - 1);
            }
        }
    }
}