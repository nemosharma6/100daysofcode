/**
 https://leetcode.com/problems/binary-tree-cameras/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int c=0;
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int k=dfs(root);
        if(k==0) c++; 
        return c;
    }
    
    public int dfs(TreeNode root) {
        if(root==null) return 2;
        int l=dfs(root.left), r=dfs(root.right);
        if(l==0 || r==0){
            c++;
            return 1;
        }
        
        return (l==1 || r==1) ? 2: 0;
    }
}
