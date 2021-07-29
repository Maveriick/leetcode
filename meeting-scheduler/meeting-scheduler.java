class Interval implements Comparable<Interval>{
    int s;
    int e;
    public Interval(int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    @Override
    public int compareTo(Interval o) {
        Interval other = (Interval)o;
        if(this.s < o.s){
            return -1;
        } else if(this.s > o.s){
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return String.format("[" + s + ", " + e +"]");
    }
}

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> solution = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.s - b.s);
        for(int i = 0; i < slots1.length; i++) {
            int[] interval = slots1[i];
            Interval inte = new Interval(interval[0], interval[1]);
            pq.add(inte);
        }
        List<Interval> sortedOne = new ArrayList<>();
        while(!pq.isEmpty()){
            sortedOne.add(pq.remove());
        }
        
        for(int i = 0; i < slots2.length; i++) {
            int[] interval = slots2[i];
            Interval inte = new Interval(interval[0], interval[1]);
            pq.add(inte);
        }
        List<Interval> sortedTwo = new ArrayList<>();
        while(!pq.isEmpty()){
            sortedTwo.add(pq.remove());
        }
        
        int s1Index = 0;
        int s2Index = 0;
        while(s1Index < sortedOne.size() && s2Index < sortedTwo.size()) {
            Interval one = sortedOne.get(s1Index);
            Interval two = sortedTwo.get(s2Index);
            
            int overlapStart = Math.max(one.s, two.s);
            int overlapEnd = Math.min(one.e, two.e);
           
            if(overlapEnd - overlapStart >= duration) {
                solution.add(overlapStart);
                solution.add(overlapStart + duration);
                return solution;
            } else {
                if(one.e <= two.e){
                    s1Index++;
                } else {
                    s2Index++;
                }
            }
        }
        
        return solution;
    }
}