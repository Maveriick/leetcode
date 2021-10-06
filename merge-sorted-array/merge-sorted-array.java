class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1Start = m - 1;
        int n2Start = n - 1;
        int solutionStart = m + n - 1;
        
        while(n1Start >= 0 && n2Start >= 0) {
            if(nums1[n1Start] > nums2[n2Start]) {
                nums1[solutionStart] = nums1[n1Start];
                n1Start --;
            } else {
                nums1[solutionStart] = nums2[n2Start];
                n2Start --;
            }
            solutionStart --;
        }
        
        if(n1Start < 0) {
            while(n2Start >= 0) {
                 nums1[solutionStart] = nums2[n2Start];
                n2Start --;
                solutionStart --;
            }
        } else {
             while(n1Start >= 0) {
                nums1[solutionStart] = nums1[n1Start];
                n1Start --;
                 solutionStart --;
            }
        }
    }
}