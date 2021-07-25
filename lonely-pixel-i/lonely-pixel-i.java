class Solution {
    public int findLonelyPixel(char[][] picture) {
        Map<Integer, Integer> rowL = new HashMap<>();
        Map<Integer, Integer> colL = new HashMap<>();
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[i].length; j++) {
                if(picture[i][j] == 'B'){
                    int fR = rowL.getOrDefault(i, 0);
                    rowL.put(i, ++fR);
                    
                    int fC = colL.getOrDefault(j, 0);
                    colL.put(j, ++fC);
                }
            }
        }
        
    
        
        int lonely = 0;
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[i].length; j++) {
                if(picture[i][j] == 'B'){
                   if(rowL.containsKey(i) && rowL.get(i) == 1 
                      && colL.containsKey(j) && colL.get(j) == 1) {
                       lonely++;
                   }
                }
            }
        }
        
        return lonely;
    }
}