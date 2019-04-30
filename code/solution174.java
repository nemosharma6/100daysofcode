/* https://leetcode.com/problems/sum-root-to-leaf-numbers/ */
class Solution {
    public int sumNumbers(TreeNode root) {
        return rec(root,0);
    }
    
    public int rec(TreeNode root, int num){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return num*10+root.val;
        int lsum=rec(root.left, num*10+root.val);
        int rsum=rec(root.right, num*10+root.val);
        return lsum+rsum;
    }
}
