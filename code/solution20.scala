/* https://leetcode.com/problems/largest-number/ */

object Solution {
    def largestNumber(nums: Array[Int]): String = {
        
        if(nums.length == 0) return ""
        if(nums.length == 1) return nums(0).toString
        
        val numList : List[Int] = nums.toList
        val sol = numList.sortWith(comparator)
        
        val stringVersion = (0 to numList.length-1).map(sol(_)).mkString("")
        val f = stringVersion.replaceAll("^0*", "");
        if(f.length == 0) "0" else f
    }
    
    def comparator(a: Int, b: Int) : Boolean = {
        
        val l1 = a.toString().concat(b.toString)
        val l2 = b.toString().concat(a.toString)
        val ind = (0 until l1.length).find(i => l1(i) != l2(i))
        
        return ind match {
            case None => false
            case Some(i) => l1(i) > l2(i)
        }
    }
}
