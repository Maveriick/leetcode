class Solution {
    Map<Integer, Boolean> state = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean isBipartite(int[][] graph) {
        Map<Integer, List<Integer>> g = buildGraph(graph);
        
        Queue<Integer> bfsQ = new LinkedList<>();
        
        
        for(int i = 0; i < graph.length; i++){
            
            if(!visited.contains(i)) {
                bfsQ.add(i);
                visited.add(0);
                state.put(i, true);
                while(!bfsQ.isEmpty()) {
                    int current = bfsQ.remove();
                    List<Integer> connections = g.getOrDefault(current, new ArrayList<Integer>());
                    for(int j = 0; j < connections.size(); j++) {
                        int toAdd = connections.get(j);
                        if(state.containsKey(toAdd) && state.get(toAdd) == state.get(current)) {
                            return false;
                        }
                        if(!visited.contains(toAdd)){
                            visited.add(toAdd);
                            state.put(toAdd, getCompliment(state.get(current)));
                            bfsQ.add(toAdd);
                        }
                        
                    }
                }
            }
        }
        
        return true;
        
    }
    
    
    
    private Map<Integer, List<Integer>> buildGraph(int[][] graph) {
         Map<Integer, List<Integer>> aList = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < graph.length; i++) {
            int src = i;
            List<Integer> children = IntStream.of(graph[i]).boxed().collect(Collectors.toList());
            List<Integer> srcList = aList.getOrDefault(src, new LinkedList<Integer>());
            srcList.addAll(children);
            aList.put(src, srcList);
        }
        return aList;
    }
    
    
    private boolean getCompliment(boolean a) {
        return !a;
    }
}