class Solution {
    public int[] getNoZeroIntegers(int n) {
        int count = 1;
        int start = n -1 ;
        while( hasZero(start) || hasZero(count)){
            start --;
            count ++;
        }
        return new int[] {count, start};
    }
    
    private boolean hasZero(int n){
        while(n != 0) {
            int digit = n % 10;
            if(digit == 0) {
                return true;
            }
            n = n /10;
        }
        return false;
    }
}