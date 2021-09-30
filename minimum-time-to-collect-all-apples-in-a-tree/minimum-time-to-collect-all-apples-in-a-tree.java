class Solution {
    Set<Integer> visited = new HashSet<>();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
       return dfs(graph, 0, hasApple);    
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, int currentVertex, List<Boolean> hasApple) {
        visited.add(currentVertex);
        List<Integer> neighbors = graph.getOrDefault(currentVertex, new ArrayList<>());
        
        int time = 0;
        for(int i = 0; i < neighbors.size(); i++) {
            if(!visited.contains(neighbors.get(i))){
                time += dfs(graph, neighbors.get(i), hasApple);
            }
        }
        
        if (currentVertex != 0 && (hasApple.get(currentVertex) || time > 0))
            time += 2;
        
        return time;
    }
    
    
    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
           int from = edges[i][0];
            int to = edges[i][1];
            
            List<Integer> fromList = graph.getOrDefault(from, new ArrayList<>());
            fromList.add(to);
            
            List<Integer> toList = graph.getOrDefault(to, new ArrayList<>());
            toList.add(from);
            
            graph.put(from, fromList);
            graph.put(to, toList);
        }
        return graph;
    }
}