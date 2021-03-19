class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            prefixSum[i+1] = currentSum;
        }
        
        int arrays = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        System.out.println(Arrays.toString(prefixSum));
        for(int i = 0; i < prefixSum.length; i++) {
                int required = prefixSum[i] - k;
                if(frequency.containsKey(required)){
                    arrays +=  frequency.get(required);
                }
                frequency.put(prefixSum[i], frequency.getOrDefault(prefixSum[i],0) + 1);
        }
        return arrays;
    }
}