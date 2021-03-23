class Solution {
    Map<Integer, Boolean> state = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> g = buildG(dislikes);
        
        Queue<Integer> bfsQ = new LinkedList<>();
        
        
        for(int i = 1; i <= dislikes.length; i++){
            
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
    
    
    private Map<Integer, List<Integer>> buildG(int[][] dislikes) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < dislikes.length; i++) {
            int from = dislikes[i][0];
            int to = dislikes[i][1];
            List<Integer> fromList = g.getOrDefault(from, new ArrayList<Integer>());
            fromList.add(to);
            g.put(from, fromList);
            
            List<Integer> toList = g.getOrDefault(to, new ArrayList<Integer>());
            toList.add(from);
            g.put(to, toList);
        }
        
        return g;
    }
    
    private boolean getCompliment(boolean a) {
        return !a;
    }
}