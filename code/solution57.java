/* https://leetcode.com/problems/minimum-window-substring/ */

class Solution {
    public String minWindow(String s, String t) {
        
        int[] tc = new int[200]; 
        for(int i=0;i<t.length();i++)
            tc[t.charAt(i)-65]++; 
            
        int i = 0, j = 0;
        int[] sc = new int[200];
        String sol = null;
        
        while(true){
            
            if(i == s.length())
                break;
            
            boolean tmp = false;
            while(i<s.length() && !compare(sc,tc)){
                sc[s.charAt(i)-65]++;
                i++;
            }
            
            while(j<s.length() && compare(sc,tc)){
                tmp = true;
                sc[s.charAt(j)-65]--;
                j++;
            }
            
            if(i == s.length() && !tmp && sol == null)
                return "";
            
            if(sol == null){
                sol = s.substring(j-1, i);
            }
            else if(sol.length() > i-j+1) {
                sol = s.substring(j-1, i);
            }
            
        }
        
        return sol;
        
    }
    
    public boolean compare(int[] a, int[] b){
        for(int i=0;i<a.length;i++)
            if(a[i]<b[i]) return false;
        return true;
    }
}
