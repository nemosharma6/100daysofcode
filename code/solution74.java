/* https://leetcode.com/problems/queue-reconstruction-by-height/  */
class Solution {
    
    static class Pair {
        int h,k;
        public Pair(int h, int k){
            this.h = h;
            this.k = k;
        }
    }
    
    public int[][] reconstructQueue(int[][] people) {
        
        if(people.length == 0 || people.length == 1)
            return people;
        
        List<Pair> l = new ArrayList();
        List<Pair> tmp = new ArrayList();
        
        for(int i=0;i<people.length;i++)
            tmp.add(new Pair(people[i][0], people[i][1]));
        
        while(!tmp.isEmpty()){
            
            Pair add = null;
            int ind = -1;
            for(int i=0;i<tmp.size();i++){
                int c=0;
                for(int j=0;j<l.size();j++)
                    if(l.get(j).h >= tmp.get(i).h)
                        c++;
                
                if(c == tmp.get(i).k){
                    if(add == null) {
                        add = tmp.get(i);
                        ind = i;
                    } 
                    else
                    if(add.h > tmp.get(i).h) {
                        add = tmp.get(i);
                        ind = i;
                    }
                }
            }
            
            l.add(add);
            tmp.remove(ind);
            
        }
        
        int ar[][] = new int[people.length][2];
        for(int i=0;i<l.size();i++){
            ar[i][0] = l.get(i).h;
            ar[i][1] = l.get(i).k;
        }
        
        return ar;
    }
}
