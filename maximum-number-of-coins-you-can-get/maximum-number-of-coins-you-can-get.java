class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int totalPiles = piles.length / 3;
        int maxCoins = 0;
        int start = totalPiles;
        while(start < piles.length){
            maxCoins += piles[start];
            start += 2;
        }
        return maxCoins;
    }
}







