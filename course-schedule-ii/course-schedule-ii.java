class Solution {
    Set<Integer> incoming = new HashSet<>();
     Stack<Integer> solution = new Stack<>();
     Set<Integer> visited = new HashSet<>();
    boolean canFinish = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       
        Map<Integer, List<Integer>> g = buildMap(prerequisites);
        System.out.println(g.toString());
       
        for(int i = 0; i < numCourses; i++) {
            if(!incoming.contains(i) && !visited.contains(i)){
                dfs(i, g, new HashSet<>());
            }
        }
        
         if(canFinish == false || visited.size() != numCourses){
            return new int[]{};
        }
        
        int[] order = new int[numCourses];
        int counter = 0;
        while(!solution.isEmpty()){
            order[counter] = solution.pop();
            counter++;
        }
    
        return order;
    }
    
    private void dfs(int currentCourse, Map<Integer, List<Integer>> g, Set<Integer> currentStack) {
        System.out.println(currentCourse);
        if(canFinish == false){
            return;
        }
        visited.add(currentCourse);
        List<Integer> dependents = g.getOrDefault(currentCourse, new ArrayList<Integer>());
        for(int i = 0; i < dependents.size(); i++){
            if(!currentStack.contains(dependents.get(i))){
                if(!visited.contains(dependents.get(i))) {
                    currentStack.add(currentCourse);
                    dfs(dependents.get(i), g, currentStack);
                    currentStack.remove(currentCourse);
                }
            } else {
                canFinish = false;
            }
        }
        
        solution.add(currentCourse);
        System.out.println(solution.toString());
        System.out.println();
    }
    
    
    private Map<Integer, List<Integer>> buildMap(int[][] pre) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < pre.length; i++) {
            int from = pre[i][1];
            int to = pre[i][0];
            List<Integer> current = g.getOrDefault(from, new ArrayList<>());
            current.add(to);
            g.put(from, current);
            incoming.add(to);
        }
        return g;
    }
}