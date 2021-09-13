class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> existing = map.getOrDefault(key, new TreeMap<Integer, String>());
        existing.put(timestamp, value);
        map.put(key, existing);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> existing = map.getOrDefault(key, new TreeMap<Integer, String>());
        Map.Entry<Integer, String> entry = existing.floorEntry(timestamp);
        if(entry == null) {
            return "";
        } else {
            return entry.getValue();
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */