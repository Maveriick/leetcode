class UnionFind {
    int totalSize;
    int[] parents;
    int[] size;
    int numComponents;
    
    public UnionFind(int size) {
        this.totalSize = size;
        this.parents = new int[size];
        this.size = new int[size];
        for(int i = 0; i < this.size.length; i++) {
            parents[i] = i;
            this.size[i] = 1;
        }
        this.numComponents = size;
    }
    
    public int findParent(int p) {
        int root = p;
        while(parents[root] != root) {
            root = parents[root];
        }
        
        while(p != root) {
            int next = parents[p];
            parents[p] = root;
            p = next;
        }
        
        return root;
    }
    
    public boolean isConnected(int person1, int person2) {
        return findParent(person1) == findParent(person2);
    }
    
    public void union(int p , int q){
        int parentP = findParent(p);
        int parentQ = findParent(q);
        if(parentP == parentQ) {
            return;
        }
        
        if(size[parentP] < size[parentQ]){
            size[parentQ] += size[parentP];
            parents[parentP] = parents[parentQ];
        } else {
            size[parentP] += size[parentQ];
            parents[parentQ] = parents[parentP];
        }
        numComponents--;
    }
    
    public boolean isSingleComponent() {
        return numComponents == 1;
    }
    
}

class TimeStamp {
    int timeStamp;
    int p;
    int q;
    
    public TimeStamp(int timeStamp, int p, int q) {
        this.timeStamp = timeStamp;
        this.p = p;
        this.q = q;
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        UnionFind unionFind = new UnionFind(n);
        
        PriorityQueue<TimeStamp> pq = new PriorityQueue<>((a,b) -> a.timeStamp - b.timeStamp);
        
        for(int i = 0; i < logs.length; i++){
            int time = logs[i][0];
            int p = logs[i][1];
            int q = logs[i][2];
            pq.add(new TimeStamp(time, p, q));
            
        }
        
        while(!pq.isEmpty()) {
            TimeStamp current = pq.poll();
            unionFind.union(current.p, current.q);
            if(unionFind.isSingleComponent()){
                return current.timeStamp;
            }
        }
      
        return -1;
    }
}