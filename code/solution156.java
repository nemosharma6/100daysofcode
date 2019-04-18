/**
 https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList();
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int l, int r){
        List<TreeNode> sol=new ArrayList();
        
        if(l>r){
            sol.add(null);
            return sol;
        }
        
        if(l==r){
            sol.add(new TreeNode(l));
            return sol;
        }
        
        for(int i=l;i<=r;i++){
            List<TreeNode> lt=helper(l,i-1);
            List<TreeNode> rt=helper(i+1,r);
            for(TreeNode l1: lt)
                for(TreeNode r1: rt){
                    TreeNode node=new TreeNode(i);
                    node.left=l1;
                    node.right=r1;
                    sol.add(node);
                }
        }
        
        return sol;
    }
}
