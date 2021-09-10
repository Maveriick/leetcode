class RandomizedSet {

    Map<Integer, Integer> valueIndex;
    List<Integer> list;
     Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueIndex = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valueIndex.containsKey(val)) {
            return false;
        }
        int currentSize = list.size();
        list.add(val);
        valueIndex.put(val, currentSize);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(valueIndex.containsKey(val)) {
            int index = valueIndex.get(val);
            int lastValue = list.get(list.size() - 1);
            list.set(index, lastValue);
            valueIndex.put(lastValue, index);
            list.remove(list.size() - 1);
            valueIndex.remove(val);
            return true;
            
        }
        
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */