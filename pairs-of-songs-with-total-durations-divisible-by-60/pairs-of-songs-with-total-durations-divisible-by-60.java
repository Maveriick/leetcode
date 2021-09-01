class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> currentF = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < time.length; i++) {
            int current = time[i];
            int required = (60 - (current % 60))%60;
            //System.out.println("current: " + current);
            //System.out.println("required: " + required);
            if(currentF.containsKey(required)) {
                pairs += currentF.get(required);
            }
            
            currentF.put(current % 60, currentF.getOrDefault(current % 60, 0) + 1);
            //System.out.println(currentF.toString());
        }
        return pairs;
    }
}

