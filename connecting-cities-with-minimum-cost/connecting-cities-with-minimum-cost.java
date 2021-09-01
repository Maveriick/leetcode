class Links {
    int from;
    int to;
    int cost;
    
    public Links(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}


class UnionFind {
    int totalSize;
    int[] parent;
    int[] size;
    int components;
    
    public UnionFind(int size) {
        this.totalSize = size;
        this.parent = new int[size];
        this.size = new int[size];
        this.components = size;
        for(int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    public int findP(int p) {
        int root = p;
        while(root != parent[root]) {
            root = parent[root];
        }
        
        while( p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        
        return root;
    }
    
    public void union(int p, int q) {
        int pParent = findP(p);
        int qParent = findP(q);
        
        if(pParent == qParent) {
            return;
        }
        
        if(size[pParent] < size[qParent]) {
            size[qParent] += size[pParent];
            parent[pParent] = parent[qParent];
        } else {
            size[pParent] += size[qParent];
            parent[qParent] = parent[pParent];
        }
        components --;
    }
    
    
    public boolean isConnected(int p, int q) {
        return findP(p) == findP(q);
    }
    
    public boolean isSingleComponent() {
        return components == 1;
    }
}

class Solution {
    public int minimumCost(int n, int[][] connections) {
        PriorityQueue<Links> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        for(int i = 0; i < connections.length; i++) {
            int p = connections[i][0];
            int q = connections[i][1];
            int cost = connections[i][2];
            Links links = new Links(p-1,q-1,cost);
            pq.add(links);
        }
        
        UnionFind unionFind = new UnionFind(n);
        int cost = 0;
        while(!pq.isEmpty()) {
            Links current = pq.poll();
            System.out.println(current.cost);
            if(!unionFind.isConnected(current.from,current.to)) {
                cost += current.cost;
                unionFind.union(current.from, current.to);
                if(unionFind.isSingleComponent()) {
                    return cost;
                }
            }
            
            
        }
        
        return -1;
    }
}