class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;
    
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }    
}



class WordDictionary {

     TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            Character current = word.charAt(i);
            if(runner.children.containsKey(current)){
                runner = runner.children.get(current);
            } else {
                TrieNode node = new TrieNode();
                runner.children.put(current, node);
                runner = runner.children.get(current);
            }
        }
        runner.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }
    
    private boolean searchRecursive(TrieNode root, String word, int index) {
        if(index >= word.length()){
            return root.isEndOfWord == true;
        }
        
        Character current = word.charAt(index);
        if(root.children.containsKey(current)) {
            return searchRecursive(root.children.get(current), word, index + 1);
        } else if(current == '.') {
            boolean isPresent = false;
            for(char i = 'a' ; i <= 'z'; i++) {
                if(root.children.containsKey(i)){
                    isPresent = isPresent || searchRecursive(root.children.get(i), word, index + 1);
                }
            }
            return isPresent;
        } else {
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */