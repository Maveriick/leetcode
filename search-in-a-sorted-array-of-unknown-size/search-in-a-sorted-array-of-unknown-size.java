/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int right = 1;
        while(reader.get(right) < target) {
            right = right * 2;
        }
        
        int left = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(reader.get(mid) == target){
                return mid;
            } else if(reader.get(mid) < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}