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
    
    class MinMax {
        Integer min=null, max=null;
        public MinMax(Integer m1, Integer m2){
            min=m1;
            max=m2;
        }
    }
    
    int sol=0;
    public int maxAncestorDiff(TreeNode root) {
        rec(root);
        return sol;
    }
    
    public MinMax rec(TreeNode root){
        if(root==null) return new MinMax(null,null);
        MinMax l=rec(root.left), r=rec(root.right);
        int lmax=Math.max(l.min!=null?Math.abs(l.min-root.val):0, l.max!=null?Math.abs(l.max-root.val):0);
        int rmax=Math.max(Math.abs(r.min!=null?r.min-root.val:0), r.max!=null?Math.abs(r.max-root.val):0);
        sol=Math.max(sol,Math.max(lmax,rmax));
        int newMin=Math.min(root.val,Math.min(l.min!=null?l.min:Integer.MAX_VALUE,r.min!=null?r.min:Integer.MAX_VALUE));
        int newMax=Math.max(root.val,Math.max(l.max!=null?l.max:Integer.MIN_VALUE,r.max!=null?r.max:Integer.MIN_VALUE));
        return new MinMax(newMin,newMax);
    }
}
