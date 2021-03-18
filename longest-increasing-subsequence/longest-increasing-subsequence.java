class Solution {
    int totalMax = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    max = Math.max(dp[j] , max);
                }
            }
            dp[i] = max + 1;
            totalMax = Math.max(totalMax, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        return totalMax;
    }
}