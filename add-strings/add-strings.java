class Solution {
    public String addStrings(String num1, String num2) {
        int num1Start = num1.length() - 1;
        int num2Start = num2.length() - 1;
        int carry = 0;
        StringBuilder resultString = new StringBuilder();
        while(num1Start >= 0 && num2Start >= 0) {
            int num1Digit = num1.charAt(num1Start) - '0';
            int num2Digit = num2.charAt(num2Start) - '0';
            int result = num1Digit + num2Digit + carry;
            if(result > 9) {
                result = result - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            resultString.insert(0, Integer.toString(result));
            num1Start --;
            num2Start --;
            
        }
        
        if(num1Start < 0) {
            while(num2Start >= 0) {
                int num2Digit = num2.charAt(num2Start) - '0';
                int result = carry + num2Digit;
                if(result > 9) {
                    result = result - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                resultString.insert(0, Integer.toString(result));
                num2Start --;
            }
        } else {
            while(num1Start >= 0) {
                int num1Digit = num1.charAt(num1Start) - '0';
                int result = carry + num1Digit;
                if(result > 9) {
                    result = result - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                resultString.insert(0, Integer.toString(result));
                num1Start --;
            }
        }
        
        if(carry == 1){
            resultString.insert(0, carry);
        }
        return resultString.toString();
    }
}