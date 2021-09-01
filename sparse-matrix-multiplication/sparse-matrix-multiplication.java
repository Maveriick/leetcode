class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] solution = new int[mat1.length][mat2[0].length];
        
        for(int i = 0; i < mat1.length; i++){
            for(int j = 0; j < mat2[0].length; j++) {
                int currentSum = 0;
                for(int k = 0; k < mat2.length; k++) {
                   
                    
                    currentSum += mat1[i][k] * mat2[k][j];
                } 
                 solution[i][j] = currentSum;
            }
           
        }
        return solution;
    }
}