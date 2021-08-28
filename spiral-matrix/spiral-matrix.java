class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        
        
        int totalElements = matrix.length * matrix[0].length;
        int elements = 0;
        List<Integer> sol = new ArrayList<>();
        while(elements < totalElements) {
            
            // Top Row
            for(int i = startCol; i <= endCol; i++ ) {
                sol.add(matrix[startRow][i]);
                elements++;
            }
            if(elements == totalElements) {
                break;
            }
            
            startRow++;
            
            
            // Right Col
            for(int i = startRow; i <= endRow; i++ ) {
                sol.add(matrix[i][endCol]);
                elements++;
            }
            if(elements == totalElements) {
                break;
            }
            
            endCol--;
            
            
            
            // Bottom Row
            for(int i = endCol; i >= startCol; i-- ) {
                sol.add(matrix[endRow][i]);
                elements++;
            }
            if(elements == totalElements) {
                break;
            }
            endRow --;
            
            
            /// Left Col
            for(int i = endRow; i >= startRow; i-- ) {
                sol.add(matrix[i][startCol]);
                elements++;
            }
            if(elements == totalElements) {
                break;
            }
            startCol++;
        }
        return sol;
        
    }
}