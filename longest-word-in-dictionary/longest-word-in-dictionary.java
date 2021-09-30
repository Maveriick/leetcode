class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;
    
    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}



class Solution {
    TrieNode root;
    int maxLength = 0;
    int maxWordIndex = -1;
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        Arrays.sort(words);
       // System.out.println(Arrays.toString(words));
        for(int i = 0; i < words.length; i++){
            addWord(words[i], i);
        }
        if(maxWordIndex == -1){
            return "";
        }
        return words[maxWordIndex];
    }
    
    public void addWord(String word, int index) {
        TrieNode runner = root;
        int count = 0;
        for(int i = 0; i < word.length() - 1; i++){
            if(!runner.children.containsKey(word.charAt(i))){
                return;
            }
            runner = runner.children.get(word.charAt(i));
            count++;
            
        }
        
        TrieNode n = new TrieNode();
        runner.children.put(word.charAt(word.length() - 1), n);
        count++;
        if(count > maxLength){
            maxLength = count;
            maxWordIndex = index;
        }
    }
    
    
    
}