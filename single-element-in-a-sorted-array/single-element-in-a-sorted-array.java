class Solution {
    int index = -1;
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        
        binarySearch(nums, start, end);
        System.out.println(index);
        return nums[index];
        
    }
    
    
    private void binarySearch(int[] nums, int start, int end){
        if(start > end){
            return ;
        }
        
        int mid = start + (end - start) / 2;
        if(mid == 0 && nums[mid + 1] != nums[mid] ) {
                index = mid;
        } else if(mid == nums.length - 1 && nums[mid] != nums[mid - 1]){
                index = mid;
        } else if((mid > 0 && nums[mid] != nums[mid - 1]) && (mid < nums.length - 1 && nums[mid] != nums[mid + 1])){
            index = mid;
        } 
        binarySearch(nums, start, mid - 1);
        binarySearch(nums, mid + 1, end);
    }
    
    

}