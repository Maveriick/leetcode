/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int totalRows = d.get(0);
        int totalCols = d.get(1);
        
        int currentRow = 0;
        int currentCol = totalCols - 1;
        
        while(currentCol >= 0 && currentRow < totalRows) {
            if(binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow ++;
            } else {
                currentCol --;
            }
        }
        
        return currentCol == totalCols - 1 ? -1 : currentCol + 1;
    }
}