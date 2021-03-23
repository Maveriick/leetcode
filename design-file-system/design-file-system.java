class FileNode{
    public int value;
    public Map<String, FileNode> children;
    public FileNode() {
        children = new HashMap<>();
    }
}

class FileManager{
    public FileNode root;
    
    public FileManager() {
        this.root = new FileNode();
    }
    
}

class FileSystem {

    FileNode root;
    public FileSystem() {
        root = new FileNode();
    }
    
    public boolean createPath(String path, int value) {
        if(path.length() <= 0) {
            return false;
        }
        FileNode runner = root;
        path = path.substring(1);
        //System.out.println(path);
        String[] parts = path.split("/");
        //System.out.println(Arrays.toString(parts));
        for(int i = 0; i < parts.length - 1; i++) {
            if(runner.children.containsKey(parts[i])){
                runner = runner.children.get(parts[i]);
            } else {
                return false;
            }
        }
        
        String toAdd = parts[parts.length - 1];
        if(runner.children.containsKey(toAdd)){
          return false;
        } else {
            FileNode toAddNode = new FileNode();
            toAddNode.value = value;
            runner.children.put(parts[parts.length - 1], toAddNode);
        }
       
        return true;
        
    }
    
    public int get(String path) {
        FileNode runner = root;
        path = path.substring(1);
        String[] parts = path.split("/");
       // System.out.println(Arrays.toString(parts));
        for(int i = 0; i < parts.length; i++) {
            if(runner.children.containsKey(parts[i])){
                runner = runner.children.get(parts[i]);
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