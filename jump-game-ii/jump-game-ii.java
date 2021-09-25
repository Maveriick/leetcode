class Solution {
    int minSteps;
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length + 1);
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));
        for(int i = 0; i < nums.length; i++) {
            int currentPossible = nums[i];
            for(int j = i + 1; j <= i + currentPossible; j++) {
                if(j < nums.length) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
           // System.out.println(Arrays.toString(dp));
        }
        
        //System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }
    
    private void hop(int[] nums, int currentIndex, int currentJumps) {
        if(currentIndex == nums.length - 1) {
            minSteps = Math.min(minSteps, currentJumps);
            return;
        }
        
        int maxPossibleJumps = nums[currentIndex];
        for(int j = maxPossibleJumps; j > 0; j--){
            if(j + currentIndex < nums.length) {
                hop(nums, currentIndex + j, currentJumps + 1);
            }
        }
    }
}