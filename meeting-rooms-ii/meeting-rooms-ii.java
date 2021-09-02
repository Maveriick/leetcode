class Interval {
    int startTime;
    int endTime;
    
    public Interval(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    @Override
    public String toString() {
        return String.format("[" + startTime + ", " + endTime + "]");
    }
    
  
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Interval> rooms = new PriorityQueue<>((a,b) -> a.endTime - b.endTime);
        if(intervals.length == 0) {
            return 0;
        }
        
        if(intervals.length == 1) {
            return 1;
        }
        
        int totalRooms = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        /*
        for(int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }
        System.out.println();
        */
        rooms.add(new Interval(intervals[0][0], intervals[0][1]));
        
        for(int i = 1; i < intervals.length; i++) {
            //System.out.println(rooms.toString());
            Interval n = new Interval(intervals[i][0], intervals[i][1]);
            if(intervals[i][0] < intervals[i-1][1]) {
                Interval earliestFinish = rooms.peek();
                if(earliestFinish.endTime <= intervals[i][0]) {
                    rooms.poll();
                }
            } else {
                rooms.poll();
            }
            rooms.add(n);
            totalRooms = Math.max(totalRooms, rooms.size());
        }

        return totalRooms;
    }
}