class SnapshotArray {
    int snap;
    Map<Integer, Map<Integer, Integer>> snapshots;
    Map<Integer, Integer> currentVals;
    public SnapshotArray(int length) {
        snap = 0;
        snapshots = new HashMap<>();
        currentVals = new HashMap<>();
    }
    
    public void set(int index, int val) {
        currentVals.put(index, val);
    }
    
    public int snap() {
        Map<Integer, Integer> snapMap = new HashMap<>(currentVals);
        snapshots.put(snap, snapMap);
        int toReturn = snap;
        snap++;
       // System.out.println(snapshots.toString());
        return toReturn;
    }
    
    public int get(int index, int snap_id) {
        Map<Integer, Integer> snapMap = snapshots.get(snap_id);
        return snapMap.getOrDefault(index ,0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */