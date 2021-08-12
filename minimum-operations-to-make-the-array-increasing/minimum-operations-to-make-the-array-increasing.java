class Solution {
    public int minOperations(int[] nums) {
        int increments = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]){
                int incrementsNeeded = nums[i-1] + 1 - nums[i];
                increments += incrementsNeeded;
                nums[i] += incrementsNeeded;
            }
        }
        return increments;
    }
}