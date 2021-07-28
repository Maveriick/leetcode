class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int rows = s.length();
        dp = new int[rows][rows];
        for (int i = 0; i < rows; i++){
            Arrays.fill(dp[i], -1);
        }
       
        return longestPalindromic(s, 0, s.length() - 1);
    }
    
    
    private int longestPalindromic(String s, int start, int end){
       
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        
        if(start == end) {
            return 1;
        }
        
        if(start > end){
            return 0;
        }
        
        if(s.charAt(start) == s.charAt(end)) {
            dp[start][end] = 2 + longestPalindromic(s, start + 1, end - 1);
        } else {
            dp[start][end] =  Math.max(longestPalindromic(s, start + 1, end), longestPalindromic(s, start, end - 1));
        }
        return dp[start][end];
    }
    
    
}