class Solution {
    Set<Integer> discovered = new HashSet<>();
    Set<Integer> processed = new HashSet<>();
    Set<Integer> hasIncoming = new HashSet<>();
    boolean canTake = true;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = buildMap(prerequisites);
        
        for(int i = 0; i < numCourses;i++) {
            if(!hasIncoming.contains(i) && !discovered.contains(i)){
                dfs(map, i);
            }
        }
        
        return processed.size() == numCourses && canTake == true;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int currentCourse) {
        if(canTake == false){
            return;
        }
        discovered.add(currentCourse);
        List<Integer> toList = map.getOrDefault(currentCourse, new ArrayList<>());
        for(int i = 0; i < toList.size(); i++) {
            if(discovered.contains(toList.get(i)) && !processed.contains(toList.get(i))) {
                canTake = false;
            }
            
            if(!discovered.contains(toList.get(i))){
                dfs(map, toList.get(i));
            }
        }
        
        processed.add(currentCourse);
    }
    
    private Map<Integer, List<Integer>> buildMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            hasIncoming.add(to);
            List<Integer> current = map.getOrDefault(from, new ArrayList<>());
            current.add(to);
            map.put(from, current);
        }
        
        return map;
    }
}