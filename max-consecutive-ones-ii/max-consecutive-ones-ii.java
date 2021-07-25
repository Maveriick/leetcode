class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
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
                if(flips == 0){
                    flips++;
                    currentOnes++;
                    maxOnes = Math.max(currentOnes, maxOnes);
                    endingWindow++;
                } else {
                    while(flips != 0){
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