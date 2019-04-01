/**
 https://leetcode.com/problems/range-sum-of-bst/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        if(root==null)
            return 0;
        
        int c=0;
        if(root.val>=L && root.val<=R)
            c+=root.val;
        
        if(root.val>R)
            c+=rangeSumBST(root.left,L,R);
        else
        if(root.val<L)
            c+=rangeSumBST(root.right,L,R);
        else {
            c+=rangeSumBST(root.left,L,R);
            c+=rangeSumBST(root.right,L,R);
        }
        
        return c;
    }
}
