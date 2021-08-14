class Solution {
    public int[] runningSum(int[] nums) {
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            nums[i] = currentSum;
        }
        return nums;
    }
}