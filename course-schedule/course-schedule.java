class Solution {
    boolean canComplete = true;
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = buildG(prerequisites);
        for(int i = 0; i < numCourses; i++) {
            if(!canComplete == false && !visited.contains(i)){
                dfs(i, g, new HashSet<>());
            }     
        }
        return canComplete;
    }
    
    
    private void dfs(int currentCourse, Map<Integer, List<Integer>> g, Set<Integer> currentStack) {
        if(canComplete == false){
            return;
        }
        visited.add(currentCourse);
        currentStack.add(currentCourse);
        List<Integer> courses = g.getOrDefault(currentCourse, new ArrayList<>());
        for(int i = 0; i < courses.size(); i++) {
            if(currentStack.contains(courses.get(i))){
                canComplete = false;
            }
            
            if(!visited.contains(courses.get(i))){
                dfs(courses.get(i), g, currentStack);
            }
        }
         currentStack.remove(currentCourse);
    }
    
    
    private Map<Integer, List<Integer>> buildG(int[][] p) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < p.length; i++) {
            int from = p[i][0];
            int to = p[i][1];
            List<Integer> cList = g.getOrDefault(from, new ArrayList<>());
            cList.add(to);
            g.put(from, cList);
        }
        return g;
    }
}