class Solution {
    public int[][] generateMatrix(int n) {
        int rows = n;
        int cols = n;
        
        int totalElements = rows * cols;
        int doneElements = 0;
        
        int currentRow = 0;
        int currentCol = 0;
        
        int rowStart = 0;
        int colStart = 0;
        
        int rowEnd = rows - 1;
        int colEnd = cols - 1;
        
        int[][] matrix = new int[rows][cols];
        
        
        int current = 1;
        List<Integer> solution = new ArrayList<Integer>();
        while(doneElements < totalElements) {
            
           // right
           for(int i = colStart ; i <= colEnd; i++) {
               matrix[rowStart][i] = current ;
               doneElements++;
               current++;
           }
           rowStart++;
            if(doneElements >= totalElements){
                break;
            }
            
           // down
           for(int i = rowStart ; i <= rowEnd; i++) {
               matrix[i][colEnd] = current ;
               doneElements++;
               current ++;
           }
            colEnd --;
            if(doneElements >= totalElements){
                break;
            }
            
            // left
           for(int i = colEnd ; i >= colStart; i--) {
               matrix[rowEnd][i] = current ;
               doneElements++;
               current ++;
           }
            rowEnd--;
            if(doneElements >= totalElements){
                break;
            }
            
            // down
           for(int i = rowEnd ; i >= rowStart; i--) {
               matrix[i][colStart] = current ;
               doneElements++;
               current ++;
           }
            colStart++;
            if(doneElements >= totalElements){
                break;
            }
        }
        return matrix;
        
    }
}