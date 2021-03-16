class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        List<Integer> travelDayList = new ArrayList<>();
        for(int day: days){
            travelDayList.add(day);
        }
        
        int[] dp = new int[days[days.length - 1] + 1];
        int[] travelDays = new int[]{1,7,30};
        
        for(int i = 1; i < dp.length; i++) {
            if(travelDayList.contains(i)){
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < costs.length; j++) {
                    if(i - travelDays[j] >= 0) {
                        min = Math.min(min, dp[i - travelDays[j]] + costs[j]);
                    } else {
                         min = Math.min(min, 0 + costs[j]);
                    }
                }
                dp[i] = min;
            } else {
                dp[i] = dp[i-1];
            }
            
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}