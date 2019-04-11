/**
 https://leetcode.com/problems/binary-search-tree-iterator/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    int c=0;
    List<Integer> li=new ArrayList();
    public BSTIterator(TreeNode root) {
        load(root);
    }
    
    public void load(TreeNode root){
        if(root==null) return;
        load(root.left);
        li.add(root.val);
        load(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        int v=li.get(c);
        c++;
        return v;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return c<li.size();
    }
}

