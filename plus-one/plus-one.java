class Solution {
    public int[] plusOne(int[] digits) {
        int lastNonNineIndex = 0;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                lastNonNineIndex = i;
            }
        }
        digits[lastNonNineIndex] += 1;
        for(int j = lastNonNineIndex + 1; j < digits.length; j++) {
            digits[j] = 0;
        }
        
        if(digits[0] != 10){
            return digits;
        } else {
            int[] solution = new int[digits.length + 1];
            solution[0] = 1;
            solution[1] = 0;
            for(int j = 2; j < digits.length; j++){
                solution[j] = digits[j];
            
            }
            return solution;
        }
    }
}