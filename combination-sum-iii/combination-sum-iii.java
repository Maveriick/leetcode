class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> candidatesList = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            candidatesList.add(i);
        }
        List<Integer> current = new ArrayList<>();
        backtrack(current, candidatesList, n, 0, k);
        return solution;
    }
    
    private void backtrack(List<Integer> current, List<Integer> candidates, int target, int currentSum, int nums) {
        if(currentSum == target && current.size() == nums) {
            solution.add(new ArrayList<Integer>(current));
            return;
        }
        
        if(currentSum > target){
            return;
        }
        
        for(int i = 0; i < candidates.size(); i++) {
            if(current.size() < nums) {
                current.add(candidates.get(i));
                List<Integer> remaining = new ArrayList<>();

                remaining.addAll(candidates.subList(i + 1, candidates.size()));
            
                backtrack(current, remaining, target, currentSum + candidates.get(i), nums);
                current.remove(current.size() - 1);
            }
            
        }
        
    }
}