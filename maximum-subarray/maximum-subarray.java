class Solution {
    public int maxSubArray(int[] nums) {
       int totalSum =Integer.MIN_VALUE;
       int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum > totalSum){
                totalSum = currentSum;
            } 
            
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return totalSum;
    }
}