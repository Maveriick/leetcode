class Solution {
    public int longestSubarray(int[] nums) {
        int startingWindow = 0;
        int endingWindow = 0;
        int k = 0;
        int length = 0;
        int currentLength = 0;
        while(endingWindow < nums.length) {
            if(nums[endingWindow] == 1){
                currentLength ++;
                endingWindow ++;
                length = Math.max(currentLength, length);
            } else {
                if(k < 1) {
                    endingWindow ++;
                    k++;
                    currentLength ++;
                   length = Math.max(currentLength, length);  
                } else {
                    while(nums[startingWindow] == 1) {
                        startingWindow ++;
                        currentLength --;
                    }
                    startingWindow ++;
                    k --;
                    currentLength --;
                }
            }
        }
        return length - 1;
    }
}