class Interval {
    int start;
    int end;
    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
    
    @Override
    public String toString() {
        return "[" + Integer.toString(start) + "," + Integer.toString(end) + "]";
    }
}

class Solution {
    PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start - b.start);
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        for(int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            Interval inter = new Interval(current[0], current[1]);
            pq.add(inter);
        }
        
        List<Interval> sorted = new ArrayList<>();
        while(!pq.isEmpty()){
            sorted.add(pq.poll());
        }
        
        List<Interval> sol = new ArrayList<>();
        Interval previous = null;
        int start = 0;
        while(start < sorted.size()) {
            if(previous == null){
                previous = sorted.get(start);
                start++;
            } else {
                Interval current = sorted.get(start);
                if(current.start <= previous.end){
                    previous.start = Math.min(previous.start, current.start);
                    previous.end = Math.max(previous.end, current.end);
                } else {
                    sol.add(previous);
                    previous = current;
                }
                start++;
            }
        }
        sol.add(previous);
        System.out.println(sol.toString());
        
        
        int[][] solution = new int[sol.size()][2];
        for(int i = 0; i < sol.size(); i++) {
            int startTime = sol.get(i).start;
            int endTime = sol.get(i).end;
            solution[i][0] = startTime;
            solution[i][1] = endTime;
        }
        return solution;
    }
}