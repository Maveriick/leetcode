class Solution {
    public boolean stoneGame(int[] piles) {
        int start = 0;
        int end = piles.length - 1;
        int alex = 0;
        int lee = 0;
        int turn = 0;
        while(start <= end) {
            if(turn % 2 == 0){
                if(piles[start] >= piles[end]){
                    alex += piles[start];
                    start++;
                } else {
                    alex += piles[end];
                    end--;
                }
            } else {
                if(piles[start] >= piles[end]){
                    lee += piles[start];
                    start++;
                } else {
                    lee += piles[end];
                    end--;
                }
            }
        }
        return alex > lee;
    }
}