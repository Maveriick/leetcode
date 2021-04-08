/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */
class Solution {
    public int getIndex(ArrayReader reader) {
        int start = 0;
        int end = reader.length() - 1;
        while(start < end){
            System.out.println(start);
            System.out.println(end);
            int mid = start + (end - start) / 2;
            int result;
            if((end - start) % 2 == 1){
               System.out.println("even elements");
                result = reader.compareSub(start, mid, mid + 1 , end);
                
            } else {
                System.out.println("odd elements");
                 result = reader.compareSub(start, mid-1, mid+1 , end);
            }
           
            if(result == 1) {
                end = mid;
            } else if(result == -1){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start > end ? start : end;
    }
}