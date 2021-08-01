class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }
        //System.out.println(indexMap.toString());
        
        
        // Compare adjacent words
        for(int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            
            
            for(int j = 0; j < currentWord.length(); j++) {
                if (j >= words[i + 1].length()) return false;
                int currentWordIndex = indexMap.get(currentWord.charAt(j));
                int nextWordIndex = indexMap.get(nextWord.charAt(j));
               
                
                if(currentWordIndex != nextWordIndex){
                    if(currentWordIndex > nextWordIndex) {
                        return false;
                    } else {
                        break;
                    }
                } 
            }
        }
            
        return true;
        
        
        
    }
}