class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            index.put(nums2[i], i);
        }
        
        for(int i = 0; i < nums1.length; i++) {
            int currentNum = nums1[i];
            int nextGreater = currentNum;
            int startIndex = index.get(currentNum);
            for(int j = startIndex + 1; j < nums2.length; j++){
                if(nums2[j] > currentNum){
                    nextGreater = nums2[j];
                    break;
                }
            }
            
            if(nextGreater == currentNum){
                nums1[i] = -1;
            } else {
                nums1[i] = nextGreater;
            }
        }
        return nums1;
    }
}