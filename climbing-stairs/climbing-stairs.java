class Solution {
    public int climbStairs(int n) {
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int[] jumps = new int[]{1,2};
        
       
        
        for(int i = 3; i <= n; i++) {
            
            for(int j = 0; j < jumps.length; j++) {
                if(i - jumps[j] > 0) {
                    dp[i] += dp[i - jumps[j]];
                }
            }
        }
        return dp[n];
    }
}