class Solution {
    Set<Integer> visited = new HashSet<>();
    Set<Integer> processed = new HashSet<>();
    boolean possible = true;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(0, rooms);
        //System.out.println(processed.toString());
        //System.out.println(possible);
        return possible == true && processed.size() == rooms.size();
    }
    
    private void dfs(int currentRoom, List<List<Integer>> rooms) {
        if(possible == false) {
            return;
        }
        visited.add(currentRoom);
        List<Integer> canVisit = rooms.get(currentRoom);
        for(int i = 0; i < canVisit.size(); i++) {
        
            if(!visited.contains(canVisit.get(i)) && canVisit.get(i) != currentRoom) {
                dfs(canVisit.get(i), rooms);
            }
            
        }
        processed.add(currentRoom);
    }
    
}