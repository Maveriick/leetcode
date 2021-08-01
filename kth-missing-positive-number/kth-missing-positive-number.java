class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> present = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            present.add(arr[i]);
        }
        
        int min = 1;
        int missingCount = 0;
        while(missingCount <= k) {
            
            if(!present.contains(min)){
                 missingCount++;
                if(missingCount == k) {
                    return min;
                 }
              
                min++;
            } else {
                min ++;
            }
        }
        return -1;
    }
}