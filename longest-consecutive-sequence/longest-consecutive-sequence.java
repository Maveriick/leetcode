class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        int longest = 1;
        Set<Integer> numSet = new HashSet<>();
        for(int i : nums){
            numSet.add(i);
        }

        
        for(int num:numSet) {
            if(!numSet.contains(num - 1)){
                int current = num;
                int streak = 1;
                while(numSet.contains(current + 1)) {
                    current += 1;
                    streak++;
                }
                
                longest = Math.max(longest, streak);
            }
        }
        return longest;
        
        
    }
}