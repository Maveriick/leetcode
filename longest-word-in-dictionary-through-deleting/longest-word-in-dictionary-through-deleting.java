class Solution {
    int index = -1;
    int maxLength = 0;
    public String findLongestWord(String s, List<String> dictionary) {
        for(int i = 0; i < dictionary.size(); i++) {
            if(canForm(s, dictionary.get(i))) {
                if(dictionary.get(i).length() > maxLength) {
                    index = i;
                    maxLength = dictionary.get(i).length();
                }
                
                if(dictionary.get(i).length() == maxLength) {
                    if(dictionary.get(i).compareTo(dictionary.get(index)) < 0) {
                         index = i;
                    }
                   
                }
            }
        }
        return index == -1 ? "" : dictionary.get(index);
    }
    
    private boolean canForm(String string, String word) {
        int stringStart = 0;
        int wordStart = 0;
        while(stringStart < string.length() && wordStart < word.length()) {
            if(string.charAt(stringStart) == word.charAt(wordStart)) {
                stringStart++;
                wordStart++;
            } else {
                stringStart++;
            }
        }
        return wordStart >= word.length() ? true : false;
    }
}