class Solution {
    Set<Integer> hasIncoming = new HashSet<>();
    boolean possible = true;
    Set<Integer> discovered = new HashSet<>();
    Set<Integer> processed = new HashSet<>();
    Stack<Integer> order = new Stack<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        for(int i = 0; i < numCourses; i++){
            if(!hasIncoming.contains(i)) {
                dfs(i, graph);
            }
        }
        
        
        
        if(hasIncoming.size() == numCourses || possible == false || processed.size() != numCourses) {
            return new int[]{};
        }
        
        System.out.println(order.toString());
        int[] solution = new int[numCourses];
        int index = 0;
        while(!order.isEmpty()){
            solution[index] = order.pop();
            index++;
        }
        
        return solution;
    }
    
    private void dfs(int currentCourse, Map<Integer, List<Integer>> graph) {
        
        discovered.add(currentCourse);
        List<Integer> neighbours = graph.getOrDefault(currentCourse, new ArrayList<>());
        for(int i  = 0; i < neighbours.size(); i++) {
            if(discovered.contains(neighbours.get(i)) && !processed.contains(neighbours.get(i))){
                possible = false;
            }
            if(!discovered.contains(neighbours.get(i))) {
                dfs(neighbours.get(i), graph);
                
            }
        }
        order.push(currentCourse);
        processed.add(currentCourse);
    }
    
    
    private Map<Integer, List<Integer>> buildGraph(int[][] prereqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < prereqs.length; i++) {
            int from = prereqs[i][1];
            int to = prereqs[i][0];
            hasIncoming.add(to);
            List<Integer> fromList = graph.getOrDefault(from, new ArrayList<>());
            fromList.add(to);
            graph.put(from, fromList);
        }
        return graph;
    }

}