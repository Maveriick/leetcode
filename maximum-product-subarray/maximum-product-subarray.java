class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int max_so_far  = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;
        
        for(int i = 1; i < nums.length; i++){
            int currentNum = nums[i];
            int temp_max = Math.max(currentNum, Math.max(max_so_far * currentNum, min_so_far * currentNum));
            min_so_far = Math.min(currentNum, Math.min(max_so_far * currentNum, min_so_far * currentNum));
            max_so_far = temp_max;
            result = Math.max(max_so_far, result);
        }
        return result;
    }
}