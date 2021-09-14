class TrieNode {
    
    String fileContent;
    TreeMap<String, TrieNode> children;
    boolean isFile;
    String fileName;
    
    public TrieNode() {
        this.children = new TreeMap<>();
        this.fileContent = "";
        this.isFile = false;
        this.fileName = null;
    }
}



class FileSystem {

    TrieNode root;
    public FileSystem() {
        root = new TrieNode();
    }
    
    public List<String> ls(String path) {
        String[] input = path.split("/");
        //System.out.println(Arrays.toString(input));
        TrieNode runner = root;
        for(int i = 1; i < input.length; i++) {
            runner = runner.children.get(input[i]);
        }
        
        if(runner == null) {
            List<String> solution = new ArrayList<>();
            solution.addAll(root.children.keySet());
            return solution;
        }
        
        if(runner.isFile == true) {
            List<String> solution = new ArrayList<>();
            solution.add(runner.fileName);
            return solution;
        } else {
            List<String> solution = new ArrayList<>();
            solution.addAll(runner.children.keySet());
            return solution;
        }
            
    }
    
    public void mkdir(String path) {
        String[] input = path.split("/");
        //System.out.println(Arrays.toString(input));
        TrieNode runner = root;
        for(int i = 1; i < input.length; i++) {
            if(runner.children.containsKey(input[i])){
                runner = runner.children.get(input[i]);
            } else {
                TrieNode node = new TrieNode();
                node.fileName = input[i];
                runner.children.put(input[i], node);
                runner = runner.children.get(input[i]);
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        
        //System.out.println("Adding");
        String[] input = filePath.split("/");
        //System.out.println(Arrays.toString(input));
        TrieNode runner = root;
        for(int i = 1; i < input.length; i++) {
            if(runner.children.containsKey(input[i])){
                runner = runner.children.get(input[i]);
            } else {
                TrieNode node = new TrieNode();
                node.fileName = input[i];
                runner.children.put(input[i], node);
                runner = runner.children.get(input[i]);
            }
        }
    
        runner.fileContent += content;
        runner.isFile = true;
        //System.out.println("done");
    }
    
    public String readContentFromFile(String filePath) {
        String[] input = filePath.split("/");
        TrieNode runner = root;
        for(int i = 1; i < input.length; i++) {
            runner = runner.children.get(input[i]);
        }
        return runner.fileContent;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */