/* https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/ */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        helper(root,0);
        return root;
    }
    
    public int helper(TreeNode node, int s){
        if(node==null) return s;
        int sum1=helper(node.right, s);
        int sum2=helper(node.left, sum1+node.val);
        node.val+=sum1;
        return sum2;
    }
}
