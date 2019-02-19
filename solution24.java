/* https://leetcode.com/problems/diagonal-traverse/ */

class Solution {
    
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if(matrix.length == 0) return new int[0];
        
        int ar[] = new int[matrix.length * matrix[0].length];
        int c=0;
        List<List<Integer>> list = new ArrayList();
        for(int i=0;i<matrix.length + matrix[0].length;i++) list.add(new ArrayList());
        
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if((i+j) % 2 == 0) list.get(i+j).add(0, matrix[i][j]);
                else list.get(i+j).add(matrix[i][j]); 
        
        for(List<Integer> e: list)
            if(e.size() > 0) for(Integer i : e) ar[c++] = i;
        
        return ar;
    }
}
