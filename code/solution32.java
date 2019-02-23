/**

 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l1 = preorder.length;
        int l2 = inorder.length;
        
        if(l1 == 0 || l2 == 0 || l1 != l2) return null;
        return helper(preorder, inorder, 0, 0, preorder.length-1);
    }
    
    public TreeNode helper(int[] pre, int[] in, int idx,int l, int r){
        
        if(l>r || idx==-1) return null;
        if(l==r) return new TreeNode(in[l]);
        
        int rt = pre[idx];
        int i = findInIn(in, rt, l, r);
        
        TreeNode root = new TreeNode(rt);
        int j = findInPre(pre, in, l, i-1, rt);
        TreeNode left = helper(pre, in, j, l, i-1);
        
        j = findInPre(pre, in, i+1, r, rt);
        TreeNode right = helper(pre, in, j, i+1, r);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public int findInIn(int[] in, int rt, int l, int r){
        for(int i=l;i<=r;i++)
            if(in[i] == rt) return i;
        return -1;
    }
    
    /* find the index in pre such that it occurs first in in[l:r]*/
    public int findInPre(int[] pre, int in[], int l, int r, int rt){
        
        for(int i=0;i<pre.length;i++)
            for(int j=l;j<=r;j++)
                if(pre[i]==in[j] && in[j] != rt) 
                    return i;
        
        return -1;
    }

}
