/* https://leetcode.com/problems/longest-common-prefix/ */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String sm="";
        for(String i: strs) 
            if(i.length()<sm.length() || sm.length()==0) sm=i;
        
        int l=0,r=sm.length()-1;
        while(l<=r){
            int m=(l+r)/2;
            boolean st=true;
            for(String i: strs){
                st=st && i.startsWith(sm.substring(0,m+1));
                if(!st) break;
            }
            
            if(st) l=m+1; 
            else r=m-1;
        }
        
        return sm.substring(0,l);
    }
}
