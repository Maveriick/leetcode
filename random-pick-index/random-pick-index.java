class Solution {

    Map<Integer, List<Integer>> indices;
    private Random rand;
    public Solution(int[] nums) {
        this.rand = new Random();
        indices = new HashMap<>();
        int l= nums.length;
        for(int i = 0; i < l; i++) {
            List<Integer> current = indices.getOrDefault(nums[i], new ArrayList<>());
            current.add(i);
            indices.put(nums[i], current);
        }
    }
    
    public int pick(int target) {
        int l = indices.get(target).size();
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */