class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            Character current = tasks[i];
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.addAll(map.values());
        
        
        
        int time = 0;
        while(!pq.isEmpty()){
            
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n + 1; i++){
                if(!pq.isEmpty()){
                     temp.add(pq.poll());
                }
            }
            
            for(int i = 0; i < temp.size(); i++)  {
                int current = temp.get(i);
                current --;
                if(current > 0) {
                    pq.add(current);
                }
            }
            
            time += pq.isEmpty() ? temp.size() : n + 1; 
        }
        return time;
    }
}