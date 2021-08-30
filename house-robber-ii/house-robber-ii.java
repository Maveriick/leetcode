class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        List<Integer> excludeLast = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++){
            excludeLast.add(nums[i]);
        }
        //System.out.println(excludeLast.toString());
        List<Integer> excludeFirst = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            excludeFirst.add(nums[i]);
        }
        //System.out.println(excludeFirst.toString());
        
        int excludeLastRob = findMax(excludeLast);
        int excludeFirstRob = findMax(excludeFirst);
        return Math.max(excludeLastRob, excludeFirstRob);
        
    }
    
    
    private int findMax(List<Integer> input) {
        //System.out.println(input.toString());
        if(input.size() == 0) {
            return 0;
        }
        
        if(input.size() == 1) {
            return input.get(0);
        }
        
        
        
        int[] dp = new int[input.size()];
        dp[0] = input.get(0);
        dp[1] = Math.max(input.get(0), input.get(1));
        for(int i = 2; i < input.size(); i++) {
            dp[i] = Math.max(input.get(i) + dp[i - 2], dp[i-1]);
        }
        return dp[dp.length - 1];
    }
}