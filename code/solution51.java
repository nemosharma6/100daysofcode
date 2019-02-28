/**
 https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        
        if(root == null) return "null";
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("#");
        
        while(queue.size() != 0){
            TreeNode node = queue.poll();
            
            boolean l = false, r = false;
            if(node.left == null){
                sb.append("null");
                sb.append("#");
            } else {
                sb.append(node.left.val);
                sb.append("#");
                queue.add(node.left);
            }
            
            if(node.right == null){
                sb.append("null");
                sb.append("#");
            } else {
                sb.append(node.right.val);
                sb.append("#");
                queue.add(node.right);
            }
        }
        
        String re = sb.toString().substring(0, sb.length() - 1);
        return re;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.equals("null")) return null;
        
        Queue<TreeNode> q = new LinkedList();
        String[] elements = data.split("#");
        
        int i=1;
        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            String ch1 = elements[i];
            String ch2 = elements[i+1];
            
            if(ch1.equals("null") && ch2.equals("null")) { 
                temp.left = null;
                temp.right = null;
            } else if(ch1.equals("null")){
                temp.left = null;
                TreeNode right = new TreeNode(Integer.parseInt(ch2));
                temp.right = right;
                q.add(right);
            } else if(ch2.equals("null")){
                temp.right = null;
                TreeNode left = new TreeNode(Integer.parseInt(ch1));
                temp.left = left;
                q.add(left);
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(ch1));
                TreeNode right = new TreeNode(Integer.parseInt(ch2));
                temp.left = left;
                temp.right = right;
                q.add(left);
                q.add(right);
            }
                
            i=i+2;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
