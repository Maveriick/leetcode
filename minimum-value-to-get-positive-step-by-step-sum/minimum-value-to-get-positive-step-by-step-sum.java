class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            prefixSum[i] = currentSum;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prefixSum.length; i++) {
            min = Math.min(min, prefixSum[i]);
        }
        if(min < 0){
            return (-1 * min) + 1;
        }
        
        return 1;
    }
}


