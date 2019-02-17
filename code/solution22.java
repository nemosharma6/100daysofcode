/* https://leetcode.com/problems/number-of-squareful-arrays/ */

class Solution {
    
    int ct = 0;
    Set<String> set = new HashSet();
    
    public int numSquarefulPerms(int[] A) {
        
        int first = A[0];
        int c=0;
        for(int i=0;i<A.length;i++) if(A[i] == first) c++;
        if(c == A.length){
            double rt = Math.sqrt(2*first);
            if(rt == Math.floor(rt)) return 1;
        }
        
        List<Integer> l = new ArrayList();
        for(int i=0;i<A.length;i++) l.add(A[i]);
        helper(l, new ArrayList(), A.length);
        return ct;
    }
    
    public void helper(List<Integer> a, List<Integer> b, int n){
        
        if(b.size() == n) {
            
            StringBuilder sb = new StringBuilder();
            for(Integer j : b) {
                sb.append(j);
                sb.append("-");
            }
            
            if(!set.contains(sb.toString()))
                set.add(sb.toString());
            else
                return;
            
            ct++;
            return;
        }
        
        for(int i = 0; i < a.size(); i++){
            
            if(b.size() >= 1){
                int p = a.get(i);
                int q = b.get(b.size() - 1);
                double rt = Math.sqrt(p+q);
                if(rt != Math.floor(rt)) continue;
            }
            
            b.add(a.get(i));
            a.remove(i);
            helper(a, b, n);
            a.add(i, b.get(b.size() - 1));
            b.remove(b.size() - 1);
        }
    }
}
