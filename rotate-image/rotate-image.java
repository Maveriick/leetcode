class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while(start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}


/*
[[1,2,3],
[4,5,6],
[7,8,9]]

Step 1

[[7,8,9],
[4,5,6],
[1,2,3]]


Goal:
[[7,4,1],
[8,5,2],
[9,6,3]]









*/