/* https://leetcode.com/problems/odd-even-jump/ */
class Solution {
    
    int[] odd,even;
    public int oddEvenJumps(int[] A) {
        
        int c=0;
        boolean[][] v = new boolean[A.length][2];
        boolean[][] s = new boolean[A.length][2];
        
        TreeMap<Integer, Integer> mp = new TreeMap();
        
        odd = new int[A.length];
        even = new int[A.length];
        
        for(int i=A.length-1;i>=0;i--){
            Integer k1 = mp.ceilingKey(A[i]);
            if(k1==null) odd[i]=Integer.MAX_VALUE;
            else odd[i]=mp.get(k1);
            
            Integer k2 = mp.floorKey(A[i]);
            if(k2==null) even[i]=Integer.MAX_VALUE;
            else even[i]=mp.get(k2);
            
            mp.put(A[i],i);
        }
        
        for(int i=0;i<A.length;i++){
            if(!v[i][1]) count(A,i,true,1,v,s);
            if(s[i][1]) c++;
        }
        
        return c;
    }
    
    public boolean count(int[] a, int num, boolean start, int r, boolean[][] v, boolean[][] s){
        
        if(num==a.length-1){
            v[num][r%2]=true;
            s[num][r%2]=true;
            return true;
        }
        
        if(v[num][r%2])
            return s[num][r%2];
        
        v[num][r%2]=true;
        int minIndex=Integer.MAX_VALUE;
        if(start || r%2==1)
            minIndex=odd[num];
        else
            minIndex=even[num];
        
        if(minIndex==Integer.MAX_VALUE){
            s[num][r%2]=false;
            return false;
        }
        
        boolean st = count(a,minIndex,false,r+1,v,s);
        s[num][r%2]=st;
        return st;
    }
}
