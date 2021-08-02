class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMinuteMap = new HashMap<>();
        for(int i = 0; i < logs.length; i++) {
            int user = logs[i][0];
            int min = logs[i][1];
            Set<Integer> current = userMinuteMap.getOrDefault(user, new HashSet<>());
            current.add(min);
            userMinuteMap.put(user, current);
        }
        
        //System.out.println(userMinuteMap.toString());
        int[] sol = new int[k];
        for(Map.Entry<Integer, Set<Integer>> entry: userMinuteMap.entrySet()) {
            if(entry.getValue().size() >= 1 && entry.getValue().size() <= k){
                int size = entry.getValue().size();
                sol[size - 1] += 1;
            }
        }
    
        return sol;
    }
}