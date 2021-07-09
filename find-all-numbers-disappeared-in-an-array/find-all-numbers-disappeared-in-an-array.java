class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            present.add(nums[i]);
        }
        
        List<Integer> solution = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            if(!present.contains(i)) {
                solution.add(i);
            }
        }
        return solution;
    }
}