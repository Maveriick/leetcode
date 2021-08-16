class Solution {
    public int climbStairs(int n) {
        int[] numWays = new int[]{1,2};
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if(n <= 1){
            return dp[n];
        }
        dp[2] = 2;
        for(int j = 3; j <= n; j++) {
            int ways = 0;
            for(int k = 0; k < numWays.length; k++) {
                if(j - numWays[k] >= 0){
                    ways += dp[j - numWays[k]];
                }
            }
            dp[j] = ways;
        }
        
        return dp[n];
    }
}