class Interval implements Comparable<Interval>{
    int startTime;
    int endTime;
    
    public Interval(int s, int e) {
        this.startTime = s;
        this.endTime = e;
    }
    
    
    @Override
    public int compareTo(Interval other) {
        return this.startTime - other.startTime;
    }
    
    @Override
    public String toString() {
        return String.format("[" + this.startTime + ", " + this.endTime + "]");
    }
    
    
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            int[][] sol = new int[1][2];
            sol[0][0] = newInterval[0];
            sol[0][1] = newInterval[1];
            return sol;
        }
        
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            Interval interval = new Interval(startTime, endTime);
            pq.add(interval);
        }
        
        Interval toAdd = new Interval(newInterval[0], newInterval[1]);
        pq.add(toAdd);
        
        List<Interval> sorted = new ArrayList<>();
        while(!pq.isEmpty()) {
            sorted.add(pq.poll());
        }
        
        System.out.println(sorted.toString());
        List<Interval> solution = new ArrayList<>();
        
        Interval previous = sorted.get(0);
        for(int i = 1; i < sorted.size(); i++) {
            Interval current = sorted.get(i);
            if(previous == null) {
                previous = current;
            }else if(previous.endTime >= current.startTime) {
                previous.endTime = Math.max(previous.endTime, current.endTime);
            } else {
                
                solution.add(previous);
                previous = current;
            }
        }
        
        if(previous != null) {
             solution.add(previous);
        }
       
        int[][] sol = new int[solution.size()][2];
        for(int i = 0; i < solution.size(); i++){
            sol[i][0] = solution.get(i).startTime;
            sol[i][1] = solution.get(i).endTime;
        }
        
        return sol;
        
        
    }
}

















