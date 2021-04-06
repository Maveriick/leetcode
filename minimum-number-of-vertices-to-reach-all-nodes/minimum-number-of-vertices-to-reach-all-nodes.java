class Solution {
    int total;
    int minNodes = 0;
    int nodes = 0;
    int visitedNodes = 0;
    Set<Integer> incoming = new HashSet<>();
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> solution = new ArrayList<>();
        total = n;
        Map<Integer, List<Integer>> g = buildMap(edges);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> bfsQ = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!incoming.contains(i)){
                bfsQ.add(i);
                nodes++;
                visitedNodes++;
                visited.add(i);
                solution.add(i);
                while(!bfsQ.isEmpty()) {
                    int current = bfsQ.remove();
                    List<Integer> connections = g.getOrDefault(current, new ArrayList<>());
                    for(int j = 0; j < connections.size(); j++){
                        if(!visited.contains(connections.get(j))){
                            visited.add(connections.get(j));
                            visitedNodes++;
                            bfsQ.add(j);
                            if(visitedNodes == n){
                                break;
                            }
                        }
                    }
                }
            }
        }
        return solution;
    }

    public Map<Integer, List<Integer>> buildMap(List<List<Integer>> edges){
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < edges.size(); i++){
            int from = edges.get(i).get(0);
            int to = edges.get(i).get(1);
            incoming.add(to);
            List<Integer> current = g.getOrDefault(from, new ArrayList<>());
            current.add(to);
            g.put(from, current);
        }
        return g;
    }
}