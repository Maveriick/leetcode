class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < costs.length; i++) {
            pq.add(costs[i]);
        }
        
        int currentSpent = 0;
        int bars = 0;
        
        while(currentSpent <= coins && !pq.isEmpty()) {
            int current = pq.peek();
            if(currentSpent + current <= coins){
                bars ++;
                currentSpent += current;
                pq.remove();
            } else {
                break;
            }
        }
        
        return bars;
    }
}