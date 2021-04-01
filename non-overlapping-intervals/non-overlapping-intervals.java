class Interval{
    public int start;
    public int end;
    public Interval(int startTime, int endTime) {
        this.start = startTime;
        this.end = endTime;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) {
            return 0;
        }
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start - b.start);
        for(int i = 0; i < intervals.length; i++){
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            pq.add(interval);
        }
        
        List<Interval> sorted = new ArrayList<>();
        while(!pq.isEmpty()) {
            sorted.add(pq.poll());
        }
        
        int removals = 0;
        List<Interval> merged = new ArrayList<>();
        Interval previous = sorted.get(0);
        for(int i = 1; i < sorted.size(); i++){
            Interval current = sorted.get(i);
            if(current.start < previous.end){
                removals ++;
                if(previous.end  > current.end){
                    previous = current;
                }
            } else {
                previous = current;
            }

        }
        return removals;
        
    }
}