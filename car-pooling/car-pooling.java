class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> capacityAtTime = new TreeMap<>();
        //Arrays.sort(trips, trips[a][1] - trips[b][1]);
        for(int i = 0; i < trips.length; i++) {
            int people = trips[i][0];
            int from = trips[i][1];
            capacityAtTime.put(from, capacityAtTime.getOrDefault(from, 0) + people);
            
            int to = trips[i][2];
            capacityAtTime.put(to, capacityAtTime.getOrDefault(to, 0) - people);
        }
        System.out.println(capacityAtTime.toString());
        
         int usedCapacity = 0;
        for(Map.Entry<Integer, Integer> entry: capacityAtTime.entrySet()) {
             usedCapacity += entry.getValue();
            if(usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}