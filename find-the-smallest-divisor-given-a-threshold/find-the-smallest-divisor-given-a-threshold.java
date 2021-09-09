class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long sum = 0;
        for(int i : nums) {
            sum += i;
        }
        
        
        long low = 1;
        long high = sum;
        
        long solution = sum;
        
        while(low <= high) {
            long mid = low + (high - low) / 2;
            //System.out.println(mid);
            int currentSum = 0;
            for(int i = 0; i < nums.length; i++) {
                currentSum += (int) Math.ceil((double)nums[i] / mid);
            }
            //System.out.println(currentSum);
            //System.out.println();
            
            if(currentSum <= threshold) {
                high = mid - 1;
                solution = Math.min(solution, mid);
            } else {
                low = mid + 1;
            }
        }
        return (int)solution;
    }
}