class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> bfsQ = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        bfsQ.add(start);
        
        while(!bfsQ.isEmpty()){
            int currentIndex = bfsQ.remove();
            if(arr[currentIndex] == 0){
                return true;
            }
            visited[currentIndex] = true;
            int jumpDistance = arr[currentIndex];
            if(currentIndex - jumpDistance >= 0){
                if(visited[currentIndex - jumpDistance] == false) {
                    bfsQ.add(currentIndex - jumpDistance);
                }
                
            }
            
            if(currentIndex + jumpDistance < arr.length){
                if(visited[currentIndex + jumpDistance] == false) {
                    bfsQ.add(currentIndex + jumpDistance);
                }
            }
        }
        return false;
        
    }
}