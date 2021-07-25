class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0){
            return 0;
        }
        int[] minCoins = new int[amount + 1];
        minCoins[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int minimum = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    minimum = Math.min(minimum, minCoins[i - coins[j]]);
                }
            }
            minCoins[i] = minimum == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + minimum;
        }
        
        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
        
    }
}


