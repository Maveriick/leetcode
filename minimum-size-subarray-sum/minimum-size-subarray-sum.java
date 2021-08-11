class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int startingWindow = 0;
        int endingWindow = 0;
        int minSize = Integer.MAX_VALUE;
        int currentSum = 0;
        while(endingWindow < nums.length && startingWindow < nums.length) {
            currentSum += nums[endingWindow];
            if(currentSum >= target) {
                minSize = Math.min(minSize, endingWindow - startingWindow + 1);
                while(currentSum >= target) {
                    minSize = Math.min(minSize, endingWindow - startingWindow + 1);
                    currentSum -= nums[startingWindow];
                    startingWindow++;
                }
            }  
            endingWindow++;
        }
        
        while(startingWindow < nums.length) {
            currentSum -= nums[startingWindow];
            if(currentSum >= target) {
                minSize = Math.min(minSize, endingWindow - startingWindow + 1);
                 minSize = Math.min(minSize, endingWindow - startingWindow + 1);
            }
            startingWindow++;
        }
        
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}