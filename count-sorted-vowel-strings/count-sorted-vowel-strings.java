class Solution {
    
    int count = 0;
    public int countVowelStrings(int n) {
        backTrack("aeiou", new StringBuilder(), n);
        return count;
    }
    
    
    private void backTrack(String input, StringBuilder current, int n){
        if(current.length() == n) {
            count ++;
            return;
        }
        
        for(int i = 0; i < input.length(); i++) {
            if(current.length() == 0){
                current.append(input.charAt(i));
                backTrack(input, current, n);
                current.deleteCharAt(current.length() -1 );
            } else {
                if(input.charAt(i) >= current.charAt(current.length() - 1)){
                    current.append(input.charAt(i));
                    backTrack(input, current, n);
                    current.deleteCharAt(current.length() -1 );
                }
            }
        }
    }
}