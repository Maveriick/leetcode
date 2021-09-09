class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums2.length];
        Arrays.fill(nextGreater, -1);
        
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums2.length; i++) {
            valueIndexMap.put(nums2[i], i);
            if(stack.isEmpty()){
                stack.push(i);
            } else {
                if(nums2[i] > nums2[stack.peek()]) {
                    while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                        int index = stack.pop();
                        nextGreater[index] = nums2[i];
                    }
                }
                stack.push(i);
            }
        }
        //System.out.println(Arrays.toString(nextGreater));
        
        int[] solution = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            int index = valueIndexMap.get(nums1[i]);
            solution[i] = nextGreater[index];
        }
        
        return solution;
        
    }
}