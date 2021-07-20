class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        
        for(int j = k; j < nums.length; j++) {
            if(q.peek() < nums[j]){
                q.poll();
                q.add(nums[j]);
            }
        }
        
        return q.peek();
    }
}