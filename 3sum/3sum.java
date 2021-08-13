class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i-1] != nums[i]){
                findSum(nums, 0 - nums[i], i);
            }
            
        }
        return solution;
    }
    
    
    
    private void findSum(int[] nums, int target, int currentIndex) {
        int start = currentIndex + 1;
        int end = nums.length - 1;
       
        
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum < target) {
                start ++;
            } else if(sum > target){
                end --;
            } else {
                List<Integer> currentSolution = new ArrayList<>();
                currentSolution.add(nums[currentIndex]);
                if(sum == target){
                    currentSolution.add(nums[start]);
                    currentSolution.add(nums[end]);
                    solution.add(currentSolution);
                    
                    int leftStart = start + 1;
                    while(leftStart < end && nums[leftStart] == nums[start]){
                        leftStart++;
                    }
                    start = leftStart;
                    
                    int rightStart = end - 1;
                    while(rightStart > start && nums[rightStart] == nums[end]) {
                        rightStart --;
                    }
                    end = rightStart;
                }
            }
        }
    } 
}