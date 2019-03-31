/**
 https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    public String dfs(TreeNode root, String s){
        
        if(root==null)
            return "Ω";
        
        String curr=String.valueOf((char)(root.val+97));
        if(root.left==null && root.right==null)
            return curr+s;
        
        String a="Ω",b="Ω";
        if(root.left!=null)
            a=dfs(root.left, curr+s);
        if(root.right!=null)
            b=dfs(root.right, curr+s);
        
        if(a.compareTo(b)<0)
            return a;
        else
            return b;
    }
}
