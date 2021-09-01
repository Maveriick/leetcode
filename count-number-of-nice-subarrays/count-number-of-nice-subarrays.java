class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] oddNumbers = new int[nums.length + 1];
        oddNumbers[0] = 0;
        int totalOddNumbers = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 1){
                totalOddNumbers++;
            }
            oddNumbers[i+1] = totalOddNumbers;
        }
        
        System.out.println(Arrays.toString(oddNumbers));
        int niceSubArrays = 0;
        Map<Integer, Integer> current = new HashMap<>();
        for(int i = 0; i < oddNumbers.length; i++) {
            int needed = oddNumbers[i] - k;
            if(current.containsKey(needed)){
                niceSubArrays += current.get(needed);
            }
            
            current.put(oddNumbers[i], current.getOrDefault(oddNumbers[i], 0) + 1);
        }
        return niceSubArrays;
    }
    
}



