class Solution {
    public int[] findBuildings(int[] heights) {
        
        List<Integer> oceanView = new ArrayList<>();
        
        int currentMax = 0;
        for(int i = heights.length - 1; i >= 0; i--) {
            if(heights[i] > currentMax) {
                oceanView.add(0,i);
            }
            currentMax = Math.max(currentMax, heights[i]);
        }
        
        //System.out.println(oceanView.size());
        
        int[] solution = new int[oceanView.size()];
        for(int i = 0; i < oceanView.size(); i++){
            solution[i] = oceanView.get(i);
        }
        
        return solution;        
    }
}