class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val row = board.size - 1
        val col = board.get(0).size - 1
        var a = arrayOf<Array<Int>>()
        var b = intArrayOf(0,0,1,-1,-1,-1,1,1)
        var c = intArrayOf(1,-1,0,0,1,-1,-1,1)
        
        for (i in 0..row) {
            var array = arrayOf<Int>()
            for (j in 0..col) array += 0
            a += array
        }
        
        for(i in 0..row){
            for(j in 0..col){
                var ct = 0
                for(k in 0..7){
                    val x = b.get(k) + i
                    val y = c.get(k) + j
                    if(x >= 0 && x <= row && y >= 0 && y <= col && board[x][y] == 1)
                        ct += 1
                }
                
                if(board[i][j] == 1 && ct < 2)
                    a[i][j] = 0
                else if(board[i][j] == 1 && ct>=2 && ct<=3)
                    a[i][j] = 1
                else if(board[i][j] == 1 && ct>3)
                    a[i][j] = 0
                else if(board[i][j] == 0 && ct == 3)
                    a[i][j] = 1
            }
        }
        
        for(i in 0..row)
            for(j in 0..col)
                board[i][j] = a[i][j]
    }
}
