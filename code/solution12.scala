// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        helper(nums, 0, nums.size)
    }
    
    def helper(nums: Array[Int], l: Int, h: Int) : TreeNode = {
        if(l == h) null
        else if(l+1 == h) {
            var node = new TreeNode(nums(l))
            node.left = null
            node.right = null
            node
        }
        else {
            val m = l + (h - l)/2;
            var node = new TreeNode(nums(m))
            node.left = helper(nums, l, m)
            node.right = helper(nums, m+1, h)
            node
        }
    }
}


