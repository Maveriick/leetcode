class Solution {
    boolean canComplete = true;
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Integer> color = new HashMap<>();
    
    public boolean isBipartite(int[][] graph) {
        Map<Integer, List<Integer>> g = buildG(graph);
        System.out.println(g.toString());
        for(int i = 0; i < graph.length; i++) {
            if(!canComplete == false && !visited.contains(i)){
                color.put(i, 0);
                dfs(i, g);
            }     
        }
        return canComplete;
    }
    
    
    private void dfs(int currentCourse, Map<Integer, List<Integer>> g) {
        //System.out.println(color.toString());
        if(canComplete == false){
            return;
        }
        visited.add(currentCourse);
        List<Integer> courses = g.getOrDefault(currentCourse, new ArrayList<>());
        for(int i = 0; i < courses.size(); i++) {
           
                if(color.containsKey(courses.get(i))){
                    if(color.get(courses.get(i)) == color.get(currentCourse)){
                        canComplete = false;
                        return;
                    }
                } else {
                    color.put(courses.get(i), complementColor(color.get(currentCourse)));
                    dfs(courses.get(i), g);
                }
        
        }
    }
    
    
    private Map<Integer, List<Integer>> buildG(int[][] p) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < p.length; i++) {
            int from = i;
            int[] to = p[i];
            List<Integer> cList = g.getOrDefault(from, new ArrayList<>());
            for(int j = 0; j < to.length; j++) {
                cList.add(to[j]);
            }
            g.put(from, cList);
        }
        return g;
    }
    
    private int complementColor(int color) {
        if(color == 1){
            return 0;
        } else {
            return 1;
        }
        
        
    }
    
    
}