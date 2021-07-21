class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;
    
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }
    
}

class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            Character current = word.charAt(i);
            if(runner.children.containsKey(current)){
                runner = runner.children.get(current);
            } else {
                return false;
            }
        }
        return runner.isEndOfWord == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for(int i = 0; i < prefix.length(); i++) {
            Character current = prefix.charAt(i);
            if(runner.children.containsKey(current)){
                runner = runner.children.get(current);
            } else {
                return false;
            }
        }
        return searchIfWordExists(runner);
    }
    
    private boolean searchIfWordExists(TrieNode c) {
        boolean exists = false;
        for(char i = 'a' ; i <= 'z'; i++) {
            if(c.children.containsKey(i)){
                return exists || searchIfWordExists(c.children.get(i));
            }
        }
        
        return c.isEndOfWord == true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */