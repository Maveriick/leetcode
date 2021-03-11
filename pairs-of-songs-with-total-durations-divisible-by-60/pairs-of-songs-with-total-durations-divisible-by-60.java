class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> f = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < time.length; i++) {
            int currentLength = time[i];
            int needed = (60 - (currentLength % 60)) % 60;
            
            if(f.containsKey(needed)) {
                pairs += f.get(needed);
            }
            int currentF = f.getOrDefault(currentLength % 60, 0);
            f.put(currentLength % 60, ++currentF);
            
        }
        
        return pairs;
    }
}


