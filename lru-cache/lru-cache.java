class DLNode {
    int key;
    int value;
    DLNode next;
    DLNode prev;
    DLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    
    @Override
    public String toString() {
        return String.format("[" + key + ", " + value + "]");
    }
   
}


class DLList {
    DLNode head;
    DLNode tail;
    int size;
    DLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addToHead(DLNode newNode) {
        if(head == null && tail == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void delete(DLNode toDelete) {
        if(toDelete.prev == null && toDelete.next == null) {
            head = tail = null;
        } else {
            DLNode prev = toDelete.prev;
            DLNode next = toDelete.next;
            if(prev != null) {
                prev.next = next;
            }
            
            if(next != null) {
                next.prev = prev;
            }
            if(tail == toDelete) {
                tail = prev;
            }
            
            if(head == toDelete) {
                head = next;
            }
            toDelete = null;
        }
    }
    
    public DLNode getTail() {
        return this.tail;
    }
    
    public void deleteTail() {
        if(tail == null) {
            return;
        }
        
        if(head == tail) {
            head = tail = null;
            return;
        }
        
        DLNode toDelete = tail;
        DLNode prev = toDelete.prev;
        prev.next = null;
        tail = prev;
        toDelete = null;
        
    }
    
    public void printList() {
        DLNode runner = head;
        while(runner != null){
            System.out.print(String.format("[" + runner.key + ", " + runner.value + "]" + "->"));
            runner = runner.next;
        }
        System.out.println();
    }
}

class LRUCache {

    Map<Integer, DLNode> keyNodeMap;
    DLList list;
    int capacity;
    public LRUCache(int capacity) {
        keyNodeMap = new HashMap<>();
        list = new DLList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(keyNodeMap.containsKey(key)) {
            
            DLNode nodeToDelete = keyNodeMap.get(key);
            int toReturn = nodeToDelete.value;
            list.delete(nodeToDelete);
            
            DLNode newNode = new DLNode(key, toReturn);
            keyNodeMap.put(key, newNode);
            list.addToHead(newNode);
            //list.printList();
            return toReturn;
        }
         //list.printList();
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)){
            DLNode nodeToDelete = keyNodeMap.get(key);
            list.delete(nodeToDelete);
            
            DLNode newNode = new DLNode(key, value);
            keyNodeMap.put(key, newNode);
            list.addToHead(newNode);
        } else {
            
            if(keyNodeMap.size() == capacity) {
                
                DLNode tail = list.getTail();
                keyNodeMap.remove(tail.key);
                list.deleteTail();
            }
           
            DLNode newNode = new DLNode(key, value);
            keyNodeMap.put(key, newNode);
            list.addToHead(newNode);
          
            
        }
        //list.printList();
    }
    

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */