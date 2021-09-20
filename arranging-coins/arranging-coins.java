class Solution {
    public int arrangeCoins(int n) {
        int steps = 0;
        while( n > steps) {
            steps ++;
            n = n - steps;
        }
        return steps;
    }
}