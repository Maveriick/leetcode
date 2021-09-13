class Solution {
    public int maxProfit(int[] prices) {
        int[] diffArray = new int[prices.length - 1];
        for(int i = 0; i < prices.length - 1; i++) {
            diffArray[i] = prices[i+1] - prices[i];
        }
        
        int currentMax = 0;
        int totalMax = 0;
        for(int i = 0; i < diffArray.length; i++) {
            currentMax += diffArray[i];
            totalMax = Math.max(totalMax, currentMax);
            
            if(currentMax < 0) {
                currentMax = 0;
            }
        }
        return totalMax;
    }
}