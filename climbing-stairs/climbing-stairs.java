class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        int[] ways = new int[]{1,2};
        for(int i = 2; i <= n + 1; i++){
            for(int j = 0; j < ways.length; j++){
                if(ways[j] <= i) {
                    dp[i] += dp[i - ways[j]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n + 1];
    }
}