class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int cF = fMap.getOrDefault(nums[i], 0);
            fMap.put(nums[i], ++cF);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(fMap.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return -1;
    }
}