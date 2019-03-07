/* https://leetcode.com/problems/couples-holding-hands/ */
class Solution {
    
    static class Pair {
        int x,y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public boolean isOk(){
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            if(max % 2 == 1 && max-min == 1)
                return true;
            
            return false;
        }
    }
    
    public int minSwapsCouples(int[] row) {
        
        List<Pair> l = new ArrayList();
        for(int i=0;i<row.length;i+=2){
            int min = Math.min(row[i], row[i+1]);
            int max = Math.max(row[i], row[i+1]);
            if(max % 2 == 1 && max-min == 1) continue;
            l.add(new Pair(row[i], row[i+1]));
        }
        
        if(l.size() == 0)
            return 0;
        
        
        int ct=0;
        while(true){
            
            while(l.size() != 0 && l.get(0).isOk())
                l.remove(0);
            
            if(l.size() == 0 || l.size() == 1)
                break;
            
            int el = l.get(0).x;
            int el2 = l.get(0).y;
            int lookingFor;
            if(el % 2 == 0)
                lookingFor = el+1;
            else
                lookingFor = el-1;
            
            for(int j=1;j<l.size();j++){
                Pair tmp = l.get(j);
                if(tmp.x == lookingFor){
                    tmp.x = el2;
                    break;
                }
                
                if(tmp.y == lookingFor){
                    tmp.y = el2;
                    break;
                }
            }
            
            ct++;
            l.remove(0);
        }
            
        return ct;
    }
}
