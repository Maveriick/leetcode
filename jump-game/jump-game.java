class Solution {
    
    
    public boolean canJump(int[] nums) {
        Queue<Integer> bfsQ = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        bfsQ.add(0);
        
        while(!bfsQ.isEmpty()) {
            int current = bfsQ.remove();
            if(current == nums.length - 1){
                return true;
            }
            int maxJump = nums[current];
            visited[current] = true;
            for(int i = current + maxJump; i > current ; i--){
                if(i < nums.length && visited[i] == false){
                    bfsQ.add(i);
                }
            }
        }
        return false;
    }
}