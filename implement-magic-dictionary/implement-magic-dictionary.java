class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;
    
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }    
}


class MagicDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++){
            addWord(dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) {
        return searchRecursive(root, searchWord, 0, 0);
    }
    
    private boolean searchRecursive(TrieNode root, String word, int index, int changed) {
        if(index >= word.length()){
          return root.isEndOfWord == true && changed == 1;
        }
    
        Character current = word.charAt(index);
        if(root.children.containsKey(current)) {
            boolean isPresent =  searchRecursive(root.children.get(current), word, index + 1, changed);
            boolean isNotPresent = false;
            for(char i = 'a' ; i <= 'z'; i++) {
                if( i != current) {
                    if(root.children.containsKey(i)){
                        isNotPresent = isNotPresent || searchRecursive(root.children.get(i), word, index + 1, changed + 1);
                    }
                }
               
            }
            
            return isPresent || isNotPresent;
        } else {
            if(changed > 1) {
                return false;
            }
            boolean isPresent = false;
            for(char i = 'a' ; i <= 'z'; i++) {
                if(root.children.containsKey(i)){
                    isPresent = isPresent || searchRecursive(root.children.get(i), word, index + 1, changed + 1);
                }
            }
            return isPresent;
        } 
    }
    
    private void addWord(String word) {
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
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */