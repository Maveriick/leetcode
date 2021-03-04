class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0){
            return false;
        }
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            int current = fMap.getOrDefault(hand[i], 0);
            fMap.put(hand[i], ++current);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < hand.length; i++){
            pq.add(hand[i]);
        }
        
        while(!pq.isEmpty()){
            int current = pq.poll();
            if(fMap.get(current) != 0) {
                for(int i = 0; i < W; i++){
                    int next = current + i;
                    if(fMap.containsKey(next) && fMap.get(next) != 0){
                        int count = fMap.get(next);
                        fMap.put(next, --count);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}