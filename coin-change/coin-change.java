class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0 || coins.length == 0) {
            return 0;
        }
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;
       
        //System.out.println(Arrays.toString(minCoins));
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i && minCoins[i - coins[j]] != Integer.MAX_VALUE){
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coins[j]] + 1);
                }
            }
        }
        //System.out.println(Arrays.toString(minCoins));
        return minCoins[amount] >= Integer.MAX_VALUE ? - 1 : minCoins[amount];
        
    }
}

