class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        int first = findPosition(nums, target, true);
        int last = findPosition(nums, target, false);
        
        if(first == -1){
            return new int[]{-1,-1};
        }
        
        return new int[]{first, last};
        
        
    }
    
    
    private int findPosition(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        int position = -1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                if(isFirst) {
                    if(mid == 0 || nums[mid] != nums[mid - 1]){
                        return mid;
                    }
                    
                    end = mid -1;
                } else {
                    if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                        return mid;
                    }
                    
                    start = mid + 1;
                }
            }
        }
        return position;
    }
}


