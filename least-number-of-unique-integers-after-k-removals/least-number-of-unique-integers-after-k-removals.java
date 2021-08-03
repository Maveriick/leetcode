class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int currentF = fMap.getOrDefault(arr[i], 0);
            fMap.put(arr[i], ++currentF);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> fMap.get(a) - fMap.get(b));
        for(Map.Entry<Integer, Integer> entry: fMap.entrySet()){
            pq.add(entry.getKey());
        }
        
        int removed = 0;
        while(!pq.isEmpty() && removed < k) {
            int maxF = pq.poll();
            int remaining = k - removed;
            if(fMap.get(maxF) <= remaining){
                removed += fMap.get(maxF);
                fMap.remove(maxF);
            }
        }
        
        return fMap.size();
    }
}