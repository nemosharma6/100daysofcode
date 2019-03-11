/* https://leetcode.com/problems/contains-duplicate/ */
object Solution {
    def containsDuplicate(nums: Array[Int]): Boolean = {
        val tmp = nums.toSet
        return !(tmp.size == nums.size)
    }
}
