https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    
    class Temp {
        int v;
        int p,m;
        public Temp(int v, int p, int m){
            this.v=v;
            this.p=p;
            this.m=m;
        }
    }
    
    int mx=0;
    public int longestConsecutive2(TreeNode root) {
        rec(root);
        return mx;
    }
    
    public Temp rec(TreeNode root){
        if(root==null) return null;
        Temp l=rec(root.left);
        Temp r=rec(root.right);
        Temp cur=new Temp(root.val,1,1);
        if(l!=null) {
            if(l.v==cur.v+1) cur.p=Math.max(cur.p,1+l.p);
            else if(l.v==cur.v-1) cur.m=Math.max(cur.m,1+l.m);
        }
        if(r!=null){
            if(r.v==cur.v+1) cur.p=Math.max(cur.p,1+r.p);
            else if(r.v==cur.v-1) cur.m=Math.max(cur.m,1+r.m);
        }
        mx=Math.max(mx, cur.p+cur.m-1);
        return cur;
    }
}
