class Solution {
    public int[] sortedSquares(int[] nums) {
        int lastNegativeIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                lastNegativeIndex = i;
            }
        }
        
        int[] solution = new int[nums.length];
        if(lastNegativeIndex == -1 ){
            for(int i = 0; i < nums.length; i++){
                solution[i] = nums[i] * nums[i];
            }
            return solution;
        } else {
            int negativeStart = lastNegativeIndex;
            int positiveStart = negativeStart + 1;
            int solStart = 0;
            while(negativeStart >= 0 && positiveStart < nums.length) {
                if(Math.abs(nums[negativeStart]) < Math.abs(nums[positiveStart])) {
                    solution[solStart] = nums[negativeStart] * nums[negativeStart];
                    negativeStart--;
                } else {
                    solution[solStart] = nums[positiveStart] * nums[positiveStart];
                    positiveStart++;
                }
                solStart++;
            }
            
            if(negativeStart < 0) {
                while(positiveStart < nums.length) {
                    solution[solStart] = nums[positiveStart] * nums[positiveStart];
                    positiveStart++;
                    solStart++;
                }
            } else {
                while(negativeStart >= 0) {
                    solution[solStart] = nums[negativeStart] * nums[negativeStart];
                    negativeStart--;
                     solStart++;
                }
            }
            return solution;
        }
    }
}