class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if(nums.length % k != 0){
            return false;
        }
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int current = fMap.getOrDefault(nums[i], 0);
            fMap.put(nums[i], ++current);
        }
        
        //System.out.println(fMap.toString());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        //System.out.println(pq.toString());
        
        while(!pq.isEmpty()){
            int current = pq.poll();
            if(fMap.get(current) != 0) {
                for(int i = 0; i < k; i++){
                    int next = current + i;
                    //System.out.println("next: " + next);
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