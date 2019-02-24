/* https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ */

object Solution {
    def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
        
        var i = 0
        while(i<nums.size){
            val t = Math.abs(nums(i))
            if(nums(t-1) > 0) nums(t - 1) = -nums(t - 1)
            i += 1
        }
        
        var l = List[Int]()
        i = 0
        while(i<nums.size){
            if(nums(i) > 0) l = l:+(i+1)
            i += 1
        }
        
        return l
    }
}
