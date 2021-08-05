class Solution {
    
    int discovered = 0;
    public boolean validTree(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> g =  buildG(edges);
        
        System.out.println(g.toString());
        System.out.println();
        
        for(int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            if(hasCycle(i, g, -1, visited) == false) {
                return false;
            }
        }
        
         Set<Integer> visited = new HashSet<>();
         visited.add(0);
         discover(0, g, -1, visited);
       
        if(discovered != n) {
            return false;
        }
        return true;
    }
    
    private boolean hasCycle(int currentVertex, Map<Integer, List<Integer>> g, int parent, Set<Integer> visited) {
      
        List<Integer> neighbors = g.getOrDefault(currentVertex, new ArrayList<>());
        for(int i = 0; i < neighbors.size(); i++) {
                 if(!visited.contains(neighbors.get(i))) {
                     visited.add(neighbors.get(i));
                     return hasCycle(neighbors.get(i), g, currentVertex, visited);
                 } else {
                     if(neighbors.get(i) != parent) {
                          return false;
                     }
                 }
        }
        return true;
    }
    
    private void discover(int currentVertex, Map<Integer, List<Integer>> g, int parent, Set<Integer> visited) {
        discovered++;
        List<Integer> neighbors = g.getOrDefault(currentVertex, new ArrayList<>());
        for(int i = 0; i < neighbors.size(); i++) {
                 if(!visited.contains(neighbors.get(i))) {
                     visited.add(neighbors.get(i));
                     discover(neighbors.get(i), g, currentVertex, visited);
                 } 
        }
    }
    
    private Map<Integer, List<Integer>> buildG(int[][] edge) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            List<Integer> currentFrom = g.getOrDefault(from, new ArrayList<>());
            currentFrom.add(to);
            g.put(from, currentFrom);
            
            List<Integer> currentTo = g.getOrDefault(to, new ArrayList<>());
            currentTo.add(from);
            g.put(to, currentTo);
            
        }
        
        return g;
    }
}