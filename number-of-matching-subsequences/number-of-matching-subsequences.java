class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int matching = 0;
        Map<String, Boolean> wordMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            
            if(wordMap.containsKey(words[i])){
                if(wordMap.get(words[i]) == true){
                    matching++;
                } 
            } else {
                if(isMatching(words[i], s)){
                    matching++;
                    wordMap.put(words[i], true);
                } else {
                     wordMap.put(words[i], false);
                }
            }
        }
        return matching;
    }
    
    private boolean isMatching(String word, String s) {
        if(s.length() < word.length()){
            return false;
        }
        int wordStart = 0;
        for(int i = 0; i < s.length(); i++) {
            if(wordStart < word.length() && s.charAt(i) == word.charAt(wordStart)){
                wordStart++;
            }
        }
        
        return wordStart == word.length() ? true : false;
    }
}