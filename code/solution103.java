/* https://leetcode.com/problems/largest-time-for-given-digits/ */
class Solution {
    
    String best = "";
    
    public String largestTimeFromDigits(int[] A) {
        String a = "";
        for(int i=0;i<A.length;i++)
            a+=String.valueOf(A[i]);
        
        rec(a,"");
        if(best=="") return best;
        return best.substring(0,2) + ":" + best.substring(2);
    }
    
    public void rec(String a, String b){
        
        if(a.length()==0){
            if(isValid(b)){
                if(best.length()==0)
                    best = b;
                else if(isBetter(b, best))
                    best=b;
            }
        }
        
        for(int i=0;i<a.length();i++)
            rec(a.substring(0,i)+a.substring(i+1), b+a.charAt(i));
    }
    
    public boolean isValid(String a){
        if(a.charAt(0)>'2') return false;
        if(a.charAt(0)=='2' && a.charAt(1)>='4') return false;
        if(a.charAt(2)>'5') return false;
        return true;
    }
    
    public boolean isBetter(String a, String b){
        
        for(int i=0;i<4;i++){
            if(a.charAt(i)>b.charAt(i))
                return true;
            if(a.charAt(i)==b.charAt(i))
                continue;
            else
                return false;
        }
        
        return false;
    }
}
