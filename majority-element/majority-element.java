class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currentF = fMap.getOrDefault(nums[i], 0);
            fMap.put(nums[i], ++currentF);
        }
        
        System.out.println(fMap.toString());
        
        for(Map.Entry<Integer, Integer> entry : fMap.entrySet()){
            if(entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        
        return -1;
    }
}