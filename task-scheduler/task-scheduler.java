class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> fMap = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            int currentF = fMap.getOrDefault(tasks[i], 0);
            ++currentF;
            fMap.put(tasks[i], currentF);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.addAll(fMap.values());
        
        
        int timeUnits = 0;
        
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n+1; i++) {
                if(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            
            for(int i = 0; i < temp.size(); i++) {
                int currentP = temp.get(i);
               currentP--;
                
                if(currentP > 0) {
                  pq.add(currentP);
                }
            }
            
            timeUnits += pq.isEmpty() ? temp.size() : n + 1;
        }
        return timeUnits;
    }
}