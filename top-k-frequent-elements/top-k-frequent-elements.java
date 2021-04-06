class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> frequencyMap.get(a) - frequencyMap.get(b));
        for(Map.Entry<Integer, Integer> e : frequencyMap.entrySet()){
            if(pq.size() < k){
                pq.add(e.getKey());
            } else {
                int top = pq.peek();
                if(frequencyMap.get(top) < e.getValue()){
                    pq.remove();
                    pq.add(e.getKey());
                }
            }
        }
        int[] solution = new int[k];
        for(int i = 0; i < k; i++){
            solution[i] = pq.remove();
        }
        return solution;
    }
}