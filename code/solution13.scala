// https://leetcode.com/problems/binary-tree-level-order-traversal/

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    
    var mp : scala.collection.mutable.Map[Int, List[Int]] = scala.collection.mutable.Map()
    var maxHeight = -1
    
    def levelOrder(root: TreeNode): List[List[Int]] = {
        
        mp.clear();
        maxHeight = -1;
        helper(root, 0);
        
        if(maxHeight == -1)
            return List();
        
        (0 to maxHeight).map { e =>
            mp(e)
        }.toList
    }
    
    def helper(root: TreeNode, height: Int) : Unit = {
        
        if(root == null) return
        
        if(maxHeight < height)
            maxHeight = height
        
        mp.exists(_._1 == height) match {
            case true => 
                val y = mp(height) :+ root.value
                mp(height) = y
            case false => 
                mp += height -> List(root.value)
        }
        
        helper(root.left, height + 1)
        helper(root.right, height + 1)
    }
}
