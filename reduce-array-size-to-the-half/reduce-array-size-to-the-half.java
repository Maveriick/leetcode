class Solution {
    public int minSetSize(int[] arr) {
        int totalSize = arr.length;
        Map<Integer, Integer> fMap = buildF(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> fMap.get(b) - fMap.get(a));
        for(Map.Entry<Integer, Integer> entry: fMap.entrySet()){
            pq.add(entry.getKey());
        }
        Set<Integer> sol = new HashSet<>();
        while(totalSize > arr.length / 2) {
            int max = pq.remove();
            sol.add(max);
            totalSize -= fMap.get(max);
        }
        
        return sol.size();
    }
    
    
    private Map<Integer, Integer> buildF(int[] arr) {
        Map<Integer, Integer> f = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int curr = f.getOrDefault(arr[i], 0);
            f.put(arr[i], ++curr);
        }
        
        return f;
    }
}