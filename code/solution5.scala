// https://leetcode.com/problems/kth-smallest-element-in-a-bst

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    
    var sol = Int.MaxValue;
    
    def kthSmallest(root: TreeNode, k: Int): Int = {
        helper(root, k, 0);
        sol
    }
    
    def helper(root: TreeNode, k: Int, c: Int) : Int = {
        if(root == null) return c;
        
        val l = helper(root.left, k, c)
        if(l == -1) return -1;
        
        if(l+1 == k){
            sol = root.value;
            return -1;
        }
        
        val r = helper(root.right, k, l + 1)
        if(r == -1) return -1;
        return r;
    }
}
