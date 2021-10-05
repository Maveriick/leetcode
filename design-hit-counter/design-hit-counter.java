class HitCounter {

    Map<Integer, Integer> counter;
    public HitCounter() {
        counter = new HashMap<>();
    }
    
    public void hit(int timestamp) {
        int current = counter.getOrDefault(timestamp, 0);
        counter.put(timestamp, current+1);
    }
    
    public int getHits(int timestamp) {
        int begin =  timestamp - 300;
        int totalHits = 0;
        for(int i = begin + 1; i <= timestamp; i++){
            if(counter.containsKey(i)) {
                totalHits += counter.get(i);
            }
        }
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */