class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int currentSum = 0;
        int totalSum = 0;
        int arrays = 0;
        prefixSum[0] = 0;
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            prefixSum[i+1] = currentSum;
            totalSum += nums[i];
        }
        
        System.out.println(Arrays.toString(prefixSum));
        for(int i = 0; i < prefixSum.length; i++) {
            for(int j = 0; j < i; j++){
                if(prefixSum[i] - prefixSum[j] == k){
                    arrays++;
                }
            }
        }
        return arrays;
    }
}



