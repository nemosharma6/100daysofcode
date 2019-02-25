/**
 https://leetcode.com/problems/house-robber-iii/
 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int rob(TreeNode root) {
        int[] num = helper(root);
        return Math.max(num[0], num[1]);
    }
    
    public int[] helper(TreeNode root) {
        
        if (root == null) 
            return new int[2];
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return res;
    }
}
