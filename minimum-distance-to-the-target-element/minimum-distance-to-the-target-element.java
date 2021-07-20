class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int currentDistance = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(Math.abs(i - start) < currentDistance) {
                    System.out.println(i);
                    System.out.println(Math.abs(i - start));
                    currentDistance = Math.min(Math.abs(i - start), currentDistance);
                    index = i;
                }
            }
        }
        return currentDistance;
    }
}