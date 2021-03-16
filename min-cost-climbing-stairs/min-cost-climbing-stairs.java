class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i = 2; i < minCost.length; i++ ) {
            
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= 2; j++) {
                if(i - j >= 0) {
                    min = Math.min(min, minCost[i - j] + (i == cost.length ? 0 : cost[i]));
                }
            }
            System.out.println(min);
            minCost[i] = min;
           
        }
        return minCost[cost.length];
    }
}