/**
 https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    
    public TreeNode helper(int[] p, int l, int r){
        if(l==r) return new TreeNode(p[l]);
        if(l>r) return null;
        TreeNode root=new TreeNode(p[l]);
        int i=l+1;
        for(;i<=r;i++) if(p[i]>p[l]) break;
        root.left=helper(p,l+1,i-1);
        root.right=helper(p,i,r);
        return root;
    }
}
