class Solution {
    public int pivotIndex(int[] nums) {
        int[] sumArray = new int[nums.length + 1];
        sumArray[0] = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i+1] = sum;
        }
        System.out.println(Arrays.toString(sumArray));
        
        for(int i = 0; i < sumArray.length-1; i++) {
            if(sumArray[i] == sum - sumArray[i+1] ){
                return i;
            }
        }
        return -1;
    }
}