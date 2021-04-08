class TrieNode{
    public Map<Character, TrieNode> children;
    boolean isEndOfWord;
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie{
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void addWord(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            Character currentChar = word.charAt(i);
            if(current.children.containsKey(currentChar)){
                current = current.children.get(currentChar);
            } else {
                TrieNode node = new TrieNode();
                current.children.put(currentChar, node);
                current = current.children.get(currentChar);
            }
        }
        current.isEndOfWord = true;
    }
    
    
    
    public boolean recursiveSearch(TrieNode current, String word, int currentIndex) {
    
        if(currentIndex  == word.length() ){
            return current.isEndOfWord;
        }
        
        if(word.charAt(currentIndex) == '.') {
            boolean wordExists = false;
            for(Map.Entry<Character, TrieNode> entry: current.children.entrySet()){
                wordExists = wordExists || recursiveSearch(current.children.get(entry.getKey()), word, currentIndex + 1);
            }
            return wordExists;
        } else {
            if(!current.children.containsKey(word.charAt(currentIndex))) {
                return false;
            } else {
                return recursiveSearch(current.children.get(word.charAt(currentIndex)), word, currentIndex + 1);
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode c = root;
        for(int i = 0; i < word.length(); i++){
            Character current = word.charAt(i);
            if(current == '.'){
                return recursiveSearch(c, word, i);
            } else if(c.children.containsKey(current)){
                c = c.children.get(current);
            } else {
                return false;
            }
        }
        return c.isEndOfWord;
    }
    
    
}

class WordDictionary {
    Trie t;

    /** Initialize your data structure here. */
    public WordDictionary() {
        t = new Trie();
    }
    
    public void addWord(String word) {
        t.addWord(word);
    }
    
    public boolean search(String word) {
        return t.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */