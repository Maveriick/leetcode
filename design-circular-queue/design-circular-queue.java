class MyCircularQueue {

    int[] storage;
    int front;
    int rear;
    int capacity;
    public MyCircularQueue(int k) {
        storage = new int[k];
        front = -1;
        rear = -1;
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % capacity;
        if(front == -1){
            front = rear;
        }
        storage[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        } else if(front == rear) {
            front = rear = -1;
            return true;
        }
        int toReturn = storage[front];
        front = (front + 1) % capacity;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return storage[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return storage[rear];
    }
    
    public boolean isEmpty() {
        if(rear == -1 && front == -1) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */