class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if(i == 0 || nums[i-1] != nums[i]){ 
                 checkPairs(nums, i, 0 - current);
            }
           
        }
        return solution;
    }
    
    
    private void checkPairs(int[] nums, int index, int target) {
        int start = index + 1;
        int end = nums.length - 1;
        
        while( start < end){
            int sum = nums[start] + nums[end];
            if(sum == target) {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(nums[index]);
                currentList.add(nums[start]);
                currentList.add(nums[end]);
                solution.add(new ArrayList<>(currentList));
                while(start < end && nums[start + 1] == nums[start]) {
                    start ++;
                }
                start++;
                
                while(end > start && nums[end - 1] == nums[end]){
                    end --;
                } 
                end--;
               
            } else if(sum < target){
                start ++;
            } else {
                end --;
            }
        }
    }
    
    
}