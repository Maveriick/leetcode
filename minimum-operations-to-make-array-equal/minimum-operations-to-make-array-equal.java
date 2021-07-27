class Solution {
    public int minOperations(int n) {
        int operations = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i * 2 + 1;
        }
        System.out.println(Arrays.toString(arr));
         for(int i = 0; i < arr.length; i++) {
                operations += Math.abs(arr[i] - n);
            }
        return operations / 2;
        
    }
}


