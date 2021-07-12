class Solution {
    public int maxProfit(int[] prices) {
        int[] diffArray = new int[prices.length -1];
        int diffArrayStart = 0;
        for(int i = 1; i < prices.length; i++) {
            diffArray[diffArrayStart] = prices[i] - prices[i - 1];
            diffArrayStart++;
        }
        
        System.out.println(Arrays.toString(diffArray));
        int maxSum = 0;
        int currentSum = 0;
        for(int i = 0; i < diffArray.length; i++) {
            currentSum += diffArray[i];
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}