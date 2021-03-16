class Solution {
     List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> candidatesList = new ArrayList<>();
        for(int i : nums) {
            candidatesList.add(i);
        }
        List<Integer> current = new ArrayList<>();
        backtrack(current, candidatesList);
        return solution;
    }
    
    
    private void backtrack(List<Integer> current, List<Integer> candidates) {
       
        if(!solution.contains(current)){
             solution.add(new ArrayList<Integer>(current));
        }
       
        
        for(int i = 0; i < candidates.size(); i++) {
                current.add(candidates.get(i));
                List<Integer> remaining = new ArrayList<>();

                remaining.addAll(candidates.subList(i + 1, candidates.size()));
                backtrack(current, remaining);
                current.remove(current.size() - 1);
            
        }
        
    }
    
    
}