class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int startRow = 0;
        int endRow = rows - 1;
        int rowIndex = -1;
    
        while(startRow <= endRow) {
            int mid = startRow + (endRow - startRow) / 2;
            if(matrix[mid][0] == target || matrix[mid][cols - 1] == target){
                return true;
            }else if(matrix[mid][0] < target && target < matrix[mid][cols - 1]){
                rowIndex = mid;
                break;
            } else if(target < matrix[mid][0]){
                endRow = mid - 1;
            } else if(target > matrix[mid][cols - 1]){
                startRow = mid + 1;
            }
        }
        
        if(rowIndex == -1){
            return false;
        }
        
        int startCol = 0;
        int endCol = cols - 1;
        while(startCol <= endCol) {
            int mid = startCol + (endCol - startCol) / 2;
            if(matrix[rowIndex][mid] == target){
                return true;
            } else if(matrix[rowIndex][mid] < target){
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }
        
        return false;
    }
}