class MyStack {

    Queue<Integer> a;
    Queue<Integer> b;
    /** Initialize your data structure here. */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        a.add(x);
        System.out.println(a.toString());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(a.size() != 1) {
            b.add(a.remove());
        }
        int toReturn = a.poll();
        while(!b.isEmpty()){
            a.add(b.poll());
        }
        return toReturn;
    }
    
    /** Get the top element. */
    public int top() {
        while(a.size() != 1) {
            b.add(a.remove());
        }
        int toReturn = a.peek();
        b.add(a.remove());
        while(!b.isEmpty()){
            a.add(b.poll());
        }
        return toReturn;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */