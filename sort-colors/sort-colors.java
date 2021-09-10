class Solution {
    public void sortColors(int[] nums) {
        int lowPtr = 0;
        int midPtr = 0;
        int highPtr = nums.length -1 ;
        
        while(midPtr <= highPtr) {
            if(nums[midPtr] == 0){
                int temp = nums[lowPtr];
                nums[lowPtr] = nums[midPtr];
                nums[midPtr] = temp;
                lowPtr ++;
                midPtr++;
            } else if(nums[midPtr] == 1) {
                midPtr++;
            } else {
                int temp = nums[highPtr];
                nums[highPtr] = nums[midPtr];
                nums[midPtr] = temp;
                highPtr --;
            }
        }
        
    }
}