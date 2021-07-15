class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0;
        int maxConsecutive = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                ones++;
                maxConsecutive = Math.max(maxConsecutive, ones);
            } else {
                ones = 0;
            }
        }
        return maxConsecutive;
    }
}