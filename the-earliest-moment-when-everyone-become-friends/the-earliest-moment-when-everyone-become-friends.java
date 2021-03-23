class Link{
    public int timeStamp;
    public int from;
    public int to;
    public Link(int timeStamp, int from, int to) {
        this.timeStamp = timeStamp;
        this.from = from;
        this.to = to;
    }
}

class Solution {
    PriorityQueue<Link> pq = new PriorityQueue<>((a,b) -> a.timeStamp - b.timeStamp);
    int[] parents;
    int[] size;
    
    public int earliestAcq(int[][] logs, int N) {
        for(int i = 0; i < logs.length; i++){
            Link l = new Link(logs[i][0], logs[i][1], logs[i][2]);
            pq.add(l);   
        }
        parents = new int[N];
        size = new int[N];
        
        // Initialize the parents & size array
        for(int i = 0; i < N; i++){
            parents[i] = i;
            size[i] = 1;
        }
        
        while(!pq.isEmpty()){
            Link current = pq.remove();
            int from = current.from;
            int to = current.to;
            System.out.println(Arrays.toString(parents));
            System.out.println(Arrays.toString(size));
            System.out.println(from);
            System.out.println(to);
            
            if(union(from, to, N) == true){
                return current.timeStamp;
            }
           
            System.out.println(Arrays.toString(parents));
            System.out.println(Arrays.toString(size));
            System.out.println();
        }
        return -1;
    }
    
    
    private int find(int x) {
        
        int root = x;
        while(parents[root] != root){
            root = parents[root];
        }
        
        while(x != root) {
            int parent = parents[x];
            parents[x] = root;
            x = parent;
        }
        return root;
    }
    
    private boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    private boolean union(int x, int y, int N) {
        int xParent = find(x);
        int yParent = find(y);
        
        if(xParent == yParent) {
            return false;
        } else {
            if(size[xParent] >= size[yParent]) {
                size[xParent] += size[yParent];
                parents[yParent] = xParent;
                if(size[xParent] == N){
                    return true;
                }
                return false;
                
            } else {
                size[yParent] += size[xParent];
                parents[xParent] = yParent;
                if(size[yParent] == N){
                    return true;
                }
                return false;
            }
        }
    }
}