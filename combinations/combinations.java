class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> input = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            input.add(i);
        }
        
        
        List<Integer> c = new ArrayList<>();
        
        permute(c, input, k, 0);
        return solution;
        
    }
    
    
    private void permute(List<Integer> current, List<Integer> total, int k, int currentIndex) {
        if(current.size() == k){
            solution.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i = currentIndex; i < total.size(); i++) {
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(total.get(i));
            
            List<Integer> newTotal = new ArrayList<>();
            newTotal.addAll(total.subList(0,i));
            newTotal.addAll(total.subList(i + 1, total.size()));
            permute(newCurrent, newTotal, k, i );
        }
    
    }
}

    