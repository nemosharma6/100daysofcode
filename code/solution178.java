/* https://leetcode.com/problems/prison-cells-after-n-days/ */
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> mp=new HashMap();
        while(N>0){
            mp.put(Arrays.toString(cells), N);
            int[] tmp=Arrays.copyOf(cells, cells.length);
            for(int i=1;i<cells.length-1;i++) cells[i]=(tmp[i+1]==tmp[i-1])?1:0;
            cells[0]=cells[cells.length-1]=0;
            String t=Arrays.toString(cells);
            N--;
            if(mp.containsKey(t)){
                int n=mp.get(t)-N;
                N=N%n;
            }
        }
        return cells;
    }
}
