// https://leetcode.com/problems/number-of-islands/

object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        
        if(grid.size == 0) return 0
        
        var chk = Array.ofDim[Boolean](grid.size, grid(0).size)
        var ct = 0
        
        (0 to grid.size - 1).foreach { i =>
            (0 to grid(0).size - 1).foreach { j =>
                if(grid(i)(j) == '1' && !chk(i)(j)) {
                    help(grid, chk, i, j)
                    ct += 1
                }
            }
        }
        
        ct
    }
    
    def help(grid: Array[Array[Char]], chk: Array[Array[Boolean]], i: Int, j: Int) : Unit = {
        if(i < 0 || j < 0 || i == grid.size || j == grid(0).size) return
        if(chk(i)(j) || grid(i)(j) == '0') return
        chk(i)(j) = true
        help(grid, chk, i+1, j)
        help(grid, chk, i, j+1)
        help(grid, chk, i-1, j)
        help(grid, chk, i, j-1)
    }
}
