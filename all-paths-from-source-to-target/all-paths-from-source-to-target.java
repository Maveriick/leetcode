class Solution {
    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> m = buildMap(graph);
        System.out.println(m.toString());
        dfs(0, m, new ArrayList<>(), graph.length - 1);
        return sol;
    }
    
    private void dfs(int currentNode, Map<Integer, List<Integer>> g, List<Integer> currentPath, int endNode) {
        List<Integer> newPath = new ArrayList<>(currentPath);
        newPath.add(currentNode);
        if(currentNode == endNode) {
            sol.add(new ArrayList<>(newPath));
            return;
        }
        
        List<Integer> connections = g.getOrDefault(currentNode, new ArrayList<>());
        for(int i = 0; i < connections.size(); i++){
                dfs(connections.get(i), g, newPath, endNode);
        }
        
    }
    
    private Map<Integer, List<Integer>> buildMap(int[][] graph) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < graph.length; i++) {
            int from = i;
            int[] to = graph[i];
            List<Integer> c = g.getOrDefault(from, new ArrayList<>());
            for(int j = 0; j < to.length; j++) {
                c.add(to[j]);
            }
            g.put(from, c);
        }
        return g;
    }
}