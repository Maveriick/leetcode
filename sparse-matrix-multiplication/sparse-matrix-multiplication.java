class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int[][] solution = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                int sol = multiply(A, B, i, j);
                solution[i][j] = multiply(A, B, i, j);
            }
        }
        return solution;
    }
    
    private int multiply(int[][] A, int[][] B, int aRow, int bCol){
        int product = 0;
        for(int i = 0; i < A[aRow].length; i++){
            product += A[aRow][i] * B[i][bCol];
            
        }
        
        return product;
    }
}