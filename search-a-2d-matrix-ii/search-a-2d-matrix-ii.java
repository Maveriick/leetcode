class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length ;
        int rowIndex = rows - 1;
        int colIndex = 0;
    
       
        while(rowIndex >= 0 && rowIndex < rows && colIndex >= 0 && colIndex < cols) {
            int currentNum = matrix[rowIndex][colIndex];
            if(currentNum == target) {
                return true;
            } else if(currentNum > target) {
                rowIndex--;
            } else {
                colIndex ++;
            }
        }
        return false;
    }
}