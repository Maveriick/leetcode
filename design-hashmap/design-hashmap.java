class Node {
    int key;
    int val;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
    
    @Override
    public String toString() {
        return String.format(key + ", " + val);
    }
}
class MyHashMap {

    ArrayList<Node>[] table;
    int maxSize = 19;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new ArrayList[19];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node n = new Node(key, value);
        int bucket = key % maxSize;
        if(table[bucket] == null) {
            ArrayList<Node> l = new ArrayList<>();
            l.add(n);
            table[bucket] = l;
        } else {
            ArrayList<Node> exist = table[bucket];
            boolean found = false;
            for(int i = 0; i < exist.size(); i++) {
                if(exist.get(i).key == key){
                    exist.get(i).val = value;
                    found = true;
                }
            }
            
            if(found == false) {
                 exist.add(n);
            }
           
            table[bucket] = exist;
        }
        //System.out.println(Arrays.toString(table));
        //System.out.println();
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % maxSize;
        if(table[bucket] == null) {
            return -1;
        } else {
           List<Node> exist = table[bucket];
            for(int i = 0; i < exist.size(); i++) {
                if(exist.get(i).key == key){
                    return exist.get(i).val;
                }
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % maxSize;
        if(table[bucket] == null) {
            return;
        } else {
           List<Node> exist = table[bucket];
            for(int i = 0; i < exist.size(); i++) {
                if(exist.get(i).key == key){
                   exist.remove(i);
                }
            }
        }
       
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */