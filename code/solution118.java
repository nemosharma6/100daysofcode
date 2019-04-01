/**
 https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int m=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return m;
    }
    
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int lt = dfs(root.left);
        int rt = dfs(root.right);
        m +=  Math.abs(lt) +  Math.abs(rt);
        return lt + rt + root.val - 1;
    }
}
