class Solution {
    public void rotate(int[] nums, int k) {
        Map<Integer, Integer> oldNewPosition = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currentPosition = i;
            int newPosition = (i + k) % nums.length;
            oldNewPosition.put(currentPosition, newPosition);
        }
        
        int[] solution = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int newPosition = oldNewPosition.get(i);
            solution[newPosition] = nums[i];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = solution[i];
        }
    }
}