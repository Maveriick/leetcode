class TrieNode{
    boolean isEndOfWord = false;
    Map<String, TrieNode> children;
    
    public TrieNode() {
        children = new HashMap<>();
    }
}

class Trie{
    TrieNode root;
    
    public Trie (){
        root = new TrieNode();
    }
    
    public boolean add(String[] s) {
        Arrays.sort(s);
        TrieNode runner = root;
        for(int i = 0; i < s.length; i++) {
            String current = s[i];
            if(runner.children.containsKey(current)){
                runner = runner.children.get(current);
                if(runner.isEndOfWord == true) {
                    return false;
                }
            } else {
                TrieNode n = new TrieNode();
                runner.children.put(current, n);
                runner = runner.children.get(current);
            }
        }
        runner.isEndOfWord = true;
        return true;
    }
}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        System.out.println(Arrays.toString(folder));
        Trie trie = new Trie();
        List<String> sol = new ArrayList<>();
        for(int i = 0; i < folder.length; i++) {
            String currentWord = folder[i];
            String[] split = currentWord.substring(1, currentWord.length()).split("/");
            if(trie.add(split)){
                sol.add(currentWord);
            } 
        }
        return sol;
    }
}