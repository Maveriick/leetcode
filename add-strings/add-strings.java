class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        int num1Start = num1.length() - 1;
        int num2Start = num2.length() - 1;
      
        int carry = 0;
        
        while(num1Start >=0 && num2Start >= 0){
            int num1Digit = Integer.parseInt(String.valueOf(num1.charAt(num1Start)));
            int num2Digit = Integer.parseInt(String.valueOf(num2.charAt(num2Start)));
            int sum = num1Digit + num2Digit + carry;
            if(sum > 9){
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
           sb.insert(0, sum);
            num1Start--;
            num2Start--;
        }
        
        
        if(num1Start < 0) {
            while(num2Start >= 0){
                int num2Digit = Integer.parseInt(String.valueOf(num2.charAt(num2Start)));
                 int sum =  num2Digit + carry;
                if(sum > 9){
                    sum = sum - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sb.insert(0, sum);
                num2Start--;
            }
        } else {
             while(num1Start >= 0){
                int num1Digit = Integer.parseInt(String.valueOf(num1.charAt(num1Start)));
                int sum = num1Digit + carry;
                if(sum > 9){
                    sum = sum - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
               sb.insert(0, sum);
                num1Start--;
            }
        }
        if(carry == 1) {
            sb.insert(0, carry);
        }
        
        
        return sb.toString();
     
        
        
        
    }
}