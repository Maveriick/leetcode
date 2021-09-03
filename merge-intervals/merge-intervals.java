class Interval {
    int startTime;
    int endTime;
    
    public Interval( int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        
        Arrays.sort(intervals, ((a,b) -> a[0] - b[0]));
        Interval previous = new Interval(intervals[0][0], intervals[0][1]);
        List<Interval> merged = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            if(previous == null) {
                previous = new Interval(intervals[i][0], intervals[i][1]);
            }else if(intervals[i][0] <= previous.endTime) {
                previous.startTime = Math.min(previous.startTime, intervals[i][0]);
                previous.endTime = Math.max(previous.endTime, intervals[i][1]);
            } else {
                merged.add(previous);
                previous = new Interval(intervals[i][0], intervals[i][1]);
            }
        }
        
        merged.add(previous);
        
        
        int[][] toReturn = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++) {
            Interval current = merged.get(i);
            toReturn[i][0] = current.startTime;
            toReturn[i][1] = current.endTime;
        }
        
        return toReturn;
                    
    }
}