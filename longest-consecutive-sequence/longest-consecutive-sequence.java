class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        
        // [0, 1,1,2]
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int current = 0;
        int longest = 0;
        while(current < nums.length - 1) {
            int start = current + 1;
            int sequence = 1;
            while(start < nums.length) {
                if(nums[start] == nums[start -1]) {
                    start ++;
                } else if(nums[start] - nums[start - 1] == 1){
                    sequence++;
                    start++;
                } else {
                    break;
                }
            }
            longest = Math.max(longest,sequence );
            current = start;
        }
        return longest;
    }
}
