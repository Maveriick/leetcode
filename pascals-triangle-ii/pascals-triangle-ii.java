class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        sol.add(first);
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        sol.add(second);
       
        for(int i = 2; i <= rowIndex; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            List<Integer> previous = sol.get(i - 1);
            for(int j = 0; j< previous.size()-1; j++){
                int sum = previous.get(j) + previous.get(j + 1);
                l.add(sum);
            }
            
            l.add(1);
            sol.add(l);
        }
        
        return sol.get(rowIndex);
    }
}