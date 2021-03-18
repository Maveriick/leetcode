class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int min = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    min = Math.max(dp[j], min);
                }
            }
            dp[i] = min + 1;
            if(dp[i] >= 3){
                return true;
            }
        }
        return false;
    }
}