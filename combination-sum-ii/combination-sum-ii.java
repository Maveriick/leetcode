class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> candidatesList = Arrays.stream(candidates)        // IntStream
                                    .boxed()          // Stream<Integer>
                                    .collect(Collectors.toList());
        List<Integer> current = new ArrayList<>();
        backtrack(current, candidatesList, target, 0);
        return solution;
    }
    
    private void backtrack(List<Integer> current, List<Integer> candidates, int target, int currentSum) {
        //System.out.println(current.toString());
        if(currentSum == target && !solution.contains(current)) {
            solution.add(new ArrayList<Integer>(current));
            return;
        }
        
        if(currentSum > target){
            return;
        }
        
        for(int i = 0; i < candidates.size(); i++) {
            current.add(candidates.get(i));
            List<Integer> remaining = new ArrayList<>();
            remaining.addAll(candidates.subList(i + 1, candidates.size()));
            
            backtrack(current, remaining, target, currentSum + candidates.get(i));
            current.remove(current.size() - 1);
        }
        
    }
}