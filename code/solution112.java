/**
 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList();
        helper(root,0,sol);
        return sol;
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> tmp){
        
        if(root==null) return;
        
        if(tmp.size()<=level)
            tmp.add(new ArrayList());
        
        if(level%2==0)
            tmp.get(level).add(root.val);
        else
            tmp.get(level).add(0, root.val);
        
        helper(root.left, level+1, tmp);
        helper(root.right, level+1, tmp);
    }
}
