class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public int[] searchRange(int[] nums, int target) {
        binarySearch(nums, 0, nums.length - 1, target);
        if(min == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        } else {
            return new int[]{min,max};
        }
        
    }
    
    private void binarySearch(int[] nums, int start, int end, int target){
        if(start > end){
            return;
        }
        int mid =  start + (end - start) / 2;
        if(nums[mid] == target){
            min = Math.min(min, mid);
            max = Math.max(max, mid);
            binarySearch(nums, start, mid - 1, target);
            binarySearch(nums, mid + 1, end, target);
        } else if(nums[mid] < target){
            binarySearch(nums, mid + 1, end, target);
        } else {
            binarySearch(nums, start, mid - 1, target);
        }
        
    }
}