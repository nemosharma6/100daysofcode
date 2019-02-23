/**

 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode right = root.right;
        TreeNode node = helper(root.left);
        
        if(root.left != null) root.right = root.left;
        if(node != null) node.right = right;
        
        root.left = null;
        TreeNode last = helper(right);
        if(last == null) return node; 
        return last;
    }
}
