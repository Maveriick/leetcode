class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int rows = text1.length();
        int cols = text2.length();
        int[][] dp = new int[rows + 1 ][cols + 1];
       
        
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++) {
                if(text2.charAt(j-1) == text1.charAt(i-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        //print(dp);
        return dp[rows][cols];
    }
    
    
    
    
    
    //Recursive
    private int lcs(String text1, int index1, String text2, int index2) {
        if(index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        
        if(text1.charAt(index1) == text2.charAt(index2)){
            return 1 + lcs(text1, index1 + 1, text2 , index2 + 1);
        } else {
            return Math.max(lcs(text1, index1 + 1, text2 , index2 ), lcs(text1, index1, text2 , index2 + 1));
        }
    }
}
