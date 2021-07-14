class Solution {
    public int maximum69Number (int num) {
        int leftMostSix = -1;
        int originalNum = num;
        
        int position = 0;
        while(num != 0) {
            int digit = num % 10;
            if(digit == 6){
                leftMostSix = position;
            }
            position ++;
            num = num / 10;
        }
        
        //System.out.println(leftMostSix);
        if(leftMostSix == -1){
            return originalNum;
        } else {
            //System.out.println((int)Math.pow(10, leftMostSix) * 3);
            return originalNum + (int)Math.pow(10, leftMostSix) * 3;
        }
    }
}