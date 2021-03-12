class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int totalElements = rows * cols;
        int doneElements = 0;
        
        int currentRow = 0;
        int currentCol = 0;
        
        int rowStart = 0;
        int colStart = 0;
        
        int rowEnd = rows - 1;
        int colEnd = cols - 1;
        
        
        List<Integer> solution = new ArrayList<Integer>();
        while(doneElements < totalElements) {
            
           // right
           for(int i = colStart ; i <= colEnd; i++) {
               solution.add(matrix[rowStart][i]);
               doneElements++;
           }
           rowStart++;
            if(doneElements >= totalElements){
                break;
            }
            
           // down
           for(int i = rowStart ; i <= rowEnd; i++) {
               solution.add(matrix[i][colEnd]);
               doneElements++;
           }
            colEnd --;
            if(doneElements >= totalElements){
                break;
            }
            
            // left
           for(int i = colEnd ; i >= colStart; i--) {
               solution.add(matrix[rowEnd][i]);
               doneElements++;
           }
            rowEnd--;
            if(doneElements >= totalElements){
                break;
            }
            
            // down
           for(int i = rowEnd ; i >= rowStart; i--) {
               solution.add(matrix[i][colStart]);
               doneElements++;
           }
            colStart++;
            if(doneElements >= totalElements){
                break;
            }
        }
        return solution;
    }
}