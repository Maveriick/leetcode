class Solution {
   List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        recursive(new ArrayList<>(), nums, used);
        return sol;
    }
    
     private void recursive(List<Integer> current, int[] nums, boolean [] used){
        if(current.size() == nums.length){
            sol.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
                if(used[i] == true || i > 0 && nums[i] == nums[i-1] && used[i - 1] == false) {
                    continue;
                }
            
                used[i] = true;
                current.add(nums[i]);
                recursive(current, nums, used);
                current.remove(current.size() - 1);
                used[i] = false;
        }
    }
}