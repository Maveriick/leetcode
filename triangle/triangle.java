class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));
        int[] ways = new int[]{0,-1};
        
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> previous = dp.get(i-1);
            List<Integer> current = triangle.get(i);
            List<Integer> currentDp = new ArrayList<>();
            
            for(int k = 0; k < current.size(); k++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < ways.length; j++) {
                    if(k + ways[j] >= 0 && k + ways[j] < previous.size()){
                         min = Math.min(min, previous.get(k + ways[j]) + current.get(k));
                    } 
                }
                currentDp.add(min);
            }
            dp.add(currentDp);
        }
        
       
        /*
        for(int i = 0; i < dp.size(); i++){
            System.out.println(dp.get(i).toString());
        }
        */
        
        int min = Integer.MAX_VALUE;
        List<Integer> lastRow = dp.get(dp.size() - 1);
        for(int i = 0; i < lastRow.size(); i++){
            min = Math.min(min, lastRow.get(i));
        }
        return min;
    
    }
}