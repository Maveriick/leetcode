class Solution {
    public int maxProfit(int[] prices) {
        int[] diffArray = new int[prices.length ];
        for(int i = 0; i < prices.length - 1; i++) {
            diffArray[i] = prices[i+1] - prices[i];
        }
        System.out.println(Arrays.toString(diffArray));
        int maxTillIndex = 0;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < diffArray.length; i++) {
            maxTillIndex += diffArray[i];
            if(maxTillIndex > maxProfit) {
                maxProfit = maxTillIndex;
            }
            
            if(maxTillIndex < 0){
                maxTillIndex = 0;
            }
        }
        return maxProfit;
    }
}


        