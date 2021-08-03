class TrieNode{
    boolean isEndOfWord;
    Map<Character, TrieNode> children;
    
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            Character current = word.charAt(i);
            if(runner.children.containsKey(current)){
                runner = runner.children.get(current);
            } else {
                TrieNode newNode = new TrieNode();
                runner.children.put(current, newNode);
                runner = runner.children.get(current);
            }
        }
        runner.isEndOfWord = true;
    }
    
    public int findMax(String word) {
        int prefixLength = 0;
        TrieNode runner = root;
        for(int i = 0; i < word.length(); i++) {
            Character current = word.charAt(i);
            if(runner.children.containsKey(current)){
                runner = runner.children.get(current);
                prefixLength ++;
            } else {
               return prefixLength;
            }
        }
        return prefixLength;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        if(strs.length == 1) {
            return strs[0];
        }
        trie.insert(strs[0]);
        int maxLength = Integer.MAX_VALUE;
        for(int i = 1; i < strs.length; i++) {
            int prefix = trie.findMax(strs[i]);
            
            maxLength = Math.min(maxLength, prefix);
        }
        return strs[0].substring(0, maxLength);
    }
}