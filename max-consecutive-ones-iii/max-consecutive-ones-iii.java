class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums.length == 0) {
            return  0;
        }
        int endingWindow = 0;
        int startingWindow = 0;
        int flips = 0;
        int currentOnes = 0;
        int maxOnes = 0;
        while(startingWindow < nums.length && endingWindow < nums.length) {
            if(nums[endingWindow] == 1) {
                currentOnes++;
                maxOnes = Math.max(currentOnes, maxOnes);
                endingWindow++;
            } else {
                if(flips < k){
                    flips++;
                    currentOnes++;
                    maxOnes = Math.max(currentOnes, maxOnes);
                    endingWindow++;
                } else {
                    while(flips >= k){
                        if(nums[startingWindow] == 1){
                            currentOnes --;
                            startingWindow++;
                        } else {
                            flips --;
                            currentOnes --;
                            startingWindow++;
                        }
                    }
                }
            }
        }
        
        return maxOnes;
    }
}