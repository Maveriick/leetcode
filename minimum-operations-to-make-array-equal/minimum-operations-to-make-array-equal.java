class Solution {
    public int minOperations(int n) {
        int moves = 0;
        int mid = n;
        for(int i = 1; i < n; i += 2){
            moves += mid - i;
        }
        return moves;
    }
}

/*
[1,3,5,7,9,11] 6
[1,3,5,7,9,11,13] 7
[1,3,5,7,9,11,13,15] 8 
*/

