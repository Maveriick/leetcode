class TrieNode {
    Integer value;
    Map<String, TrieNode> children;
    
    public TrieNode() {
        this.children = new HashMap<>();
        this.value = null;
    }
}

class FileSystem {

    TrieNode root;
    public FileSystem() {
        root = new TrieNode();
    }
    
    public boolean createPath(String path, int value) {
        String[] split = path.substring(1, path.length()).split("/");
       
        TrieNode runner = root;
        for(int i = 0; i < split.length; i++) {
            if(runner.children.containsKey(split[i])){
                runner = runner.children.get(split[i]);
            } else {
                if(i != split.length - 1){
                    return false;
                } else {
                    TrieNode n = new TrieNode();
                    runner.children.put(split[i], n);
                    runner = runner.children.get(split[i]);
                }
            }
        }
        
        if(runner.value != null) {
            return false;
        }
        runner.value = value;
        return true;
    }
    
    public int get(String path) {
        String[] split = path.substring(1, path.length()).split("/");
         //System.out.println(Arrays.toString(split));
        TrieNode runner = root;
        for(int i = 0; i < split.length; i++) {
            if(runner.children.containsKey(split[i])){
                runner = runner.children.get(split[i]);
            } else {
                return -1;
            }
        }
        return runner.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */