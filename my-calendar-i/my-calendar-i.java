class Event {
    int startTime;
    int endTime;
    public Event(int s, int e) {
        this.startTime = s;
        this.endTime = e;
    }
    
    Event left;
    Event right;
}

class MyCalendar {
    Event root;
    
    public MyCalendar() {
        root = null;
    }
    
    public boolean book(int start, int end) {
        if(root == null) {
            root = new Event(start,end);
            return true;
        } else {
            Event runner = root;
            Event prev = null;
            while(runner != null) {
                prev = runner;
                if(start >= runner.endTime){
                    runner = runner.right;
                } else if(end <= runner.startTime){
                    runner = runner.left;
                } else {
                    return false;
                }
            }
            
            if(prev.endTime <= start){
                prev.right = new Event(start, end);
            }
            
            if(prev.startTime >= end){
                prev.left = new Event(start, end);
            }
            return true;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */