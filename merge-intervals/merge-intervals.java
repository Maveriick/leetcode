class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start - b.start);
        for(int i = 0; i < intervals.length; i++) {
            Interval toAdd = new Interval(intervals[i][0], intervals[i][1]);
            pq.add(toAdd);
        }
        
        List<Interval> sorted = new ArrayList<>();
        while(!pq.isEmpty()) {
            sorted.add(pq.poll());
        }
        
        List<Interval> merged = new ArrayList<>();
        
        Interval previous = null;
        int start = 0;
        while(start < sorted.size()) {
            Interval current = sorted.get(start);
            if(previous == null) {
                previous = current;
            } else if(previous.end >= current.start) {
                previous.start = Math.min(previous.start, current.start);
                previous.end = Math.max(previous.end, current.end);
            } else {
                merged.add(previous);
                previous = current;
            }
            start++;
        }
        merged.add(previous);
        int[][] solution = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++) {
            solution[i][0] = merged.get(i).start;
            solution[i][1] = merged.get(i).end;
        }
        return solution;
    }
}