class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mStart = m - 1;
        int nStart = n - 1;
        int mergeStart = m + n - 1;
        
        while(mStart >= 0 && nStart >= 0) {
            if(nums1[mStart] >= nums2[nStart]) {
                nums1[mergeStart] = nums1[mStart];
                mStart --;
            } else {
                nums1[mergeStart] = nums2[nStart];
                nStart --;
            }
            mergeStart--;
        }
        
        if(mStart < 0) {
            while(nStart >= 0) {
                nums1[mergeStart] = nums2[nStart];
                nStart --;
                mergeStart--;
            }
        } else {
            while(mStart >= 0) {
                nums1[mergeStart] = nums1[mStart];
                mStart --;
                mergeStart--;
            }
        }
    }
}