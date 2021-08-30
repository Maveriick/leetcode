/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = serializeRecursive(root, new StringBuilder());
        if(sb.length() > 0) {
            return sb.substring(0, sb.length());
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] parsed = data.split(" ");
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i < parsed.length; i++) {
            input.add(Integer.parseInt(parsed[i]));
        }
        
        return buildTree(input);
    }
    
    
    private StringBuilder serializeRecursive(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return sb;
        }
        sb.append(root.val);
        sb.append(' ');
        serializeRecursive(root.left, sb);
        serializeRecursive(root.right, sb);
        return sb;
    } 
    
    private TreeNode buildTree(List<Integer> input) {
        if(input.size() == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(input.get(0));
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for(int i = 1; i < input.size(); i++) {
            if(input.get(i) < input.get(0)){
                leftList.add(input.get(i));
            } else {
                rightList.add(input.get(i));
            }
        }
        root.left = buildTree(leftList);
        root.right = buildTree(rightList);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;