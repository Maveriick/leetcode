class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int numElements = matrix.length * matrix[0].length;
        int elements = 0;
        List<Integer> sol = new ArrayList<>();
        while(elements < numElements) {
          
            for(int i = colStart; i <= colEnd; i++) {
                sol.add(matrix[rowStart][i]);
                elements++;
            }
            rowStart ++;
            System.out.println(elements);
            System.out.println("Num" + elements);
            if(elements == numElements) {
                break;
            }
            
           
            
            for(int i = rowStart; i <= rowEnd; i++){
                sol.add(matrix[i][colEnd]);
                elements++;
            }
            colEnd --;
            System.out.println(elements);
             if(elements == numElements) {
                break;
            }
           
            
            for(int i = colEnd; i >= colStart; i--) {
                sol.add(matrix[rowEnd][i]);
                elements++;
            }
            rowEnd --;
            System.out.println(elements);
             if(elements == numElements) {
                break;
            }
            
            
            for(int i = rowEnd; i >= rowStart; i--){
                sol.add(matrix[i][colStart]);
                elements++;
            }
            colStart++;
            System.out.println(elements);
             if(elements == numElements) {
                break;
            }
            
        }
        
        return sol;
    }
}


/*
1 2 3 4 0
5 6 7 8
9 9 9 9 2
*/