class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int tenty = 0;
        for(int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if(bill == 5){
                five++;
            } else if(bill == 10) {
                ten++;
                if(five >= 1){
                    five --;
                } else {
                    return false;
                }

            } else {
                tenty++;
                
                if (five >=1 && ten >= 1){
                    five --;
                    ten --;
                } else if(five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
            System.out.println(five);
             System.out.println(ten);
             System.out.println(tenty);
            System.out.println();
        }
        return true;
    }
}