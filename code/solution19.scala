/**
 https://leetcode.com/problems/merge-k-sorted-lists/
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

import scala.collection.mutable.PriorityQueue

object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        val q = new PriorityQueue[(Int, Int)]()(Ordering.by(diff))
        
        if(lists.size == 0) return null
        if(lists.size == 1) return lists(0)
        
        (0 to lists.size - 1).foreach { i =>
            if(lists(i) != null) {
                q.enqueue((i, lists(i).x))
                lists(i) = lists(i).next
            }
        }
        
        if(q.isEmpty) return lists(0)
        
        var head : ListNode = null
        var prev : ListNode = null
        
        while(!q.isEmpty){
            
            val pop = q.dequeue()
            val node = ListNode(pop._2)
            
            if(head == null) {
                head = node
                prev = node
            } else {
                prev.next = node
                prev = node
            }
            
            if(lists(pop._1) != null) {
                q.enqueue((pop._1, lists(pop._1).x))
                lists(pop._1) = lists(pop._1).next
            }
        }
        
        return head;
    }
    
    def diff(t2: (Int, Int)) = -t2._2
}
