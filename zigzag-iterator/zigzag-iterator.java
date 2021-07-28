public class ZigzagIterator {

    int count;
    int v1Index;
    int v2Index;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        count = 0;
        v1Index = 0;
        v2Index = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if(count % 2 == 0) {
            int toReturn = -1;
            if(v1Index < v1.size()){
                toReturn = v1.get(v1Index);
                v1Index++;
            } else if(v2Index < v2.size()) {
                 toReturn = v2.get(v2Index);
                 v2Index++;
            } 
            count++;
            return toReturn;
        } else {
            int toReturn = -1;
            if(v2Index < v2.size()) {
                 toReturn = v2.get(v2Index);
                 v2Index++;
            
            } else if(v1Index < v1.size()){
                toReturn = v1.get(v1Index);
                v1Index++;
                
            } 
            count++;
            return toReturn;
        }
    }

    public boolean hasNext() {
        return  v1Index < v1.size() || v2Index < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */