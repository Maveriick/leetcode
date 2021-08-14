class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i],0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.addAll(map.values());
        
        
        int cycles = 0;
        
        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n + 1; i++){
                if(!pq.isEmpty()) {
                    temp.add(pq.remove());
                }
            }
            
            for(int i : temp){
                if(--i > 0){
                    pq.add(i);
                }
            }
            cycles += pq.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
        
        
    }
}