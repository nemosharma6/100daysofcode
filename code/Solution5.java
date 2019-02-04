// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int sol = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k, 0);
        return sol;
    }
    
    public int helper(TreeNode root, int k, int count){
        
        if(root == null){
            return count;
        }
        
        int l = helper(root.left, k, count);
        if(l == -1) return -1;
        
        if(l + 1 == k){
            sol = root.val;
            return -1;
        }
        
        int r = helper(root.right, k, l + 1);
        if(r == -1) return -1;
        
        return r;
    }
}
