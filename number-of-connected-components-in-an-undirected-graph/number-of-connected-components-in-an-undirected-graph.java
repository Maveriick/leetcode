class Solution {
    Set<Integer> visited = new HashSet<>();
    int components = 0;
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> g = buildGraph(edges);
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                components++;
                dfs(g, i);
            }
        }
        return components;
    }
    
    private void dfs(Map<Integer, List<Integer>> g, int currentVertex) {
        visited.add(currentVertex);
        List<Integer> connections = g.getOrDefault(currentVertex, new ArrayList<>());
        for(int i = 0; i < connections.size(); i++) {
            if(!visited.contains(connections.get(i))) {
                dfs(g, connections.get(i));
            }
        }
    }
    
    
    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            List<Integer> fromList = g.getOrDefault(from, new ArrayList<>());
            fromList.add(to);
            g.put(from ,fromList);
            
            List<Integer> toList = g.getOrDefault(to, new ArrayList<>());
            toList.add(from);
            g.put(to, toList);
        }
        return g;
    }
}