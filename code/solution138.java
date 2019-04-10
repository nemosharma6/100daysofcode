/* https://leetcode.com/problems/remove-duplicate-letters/ */
class Solution {
    public String removeDuplicateLetters(String s) {
        String sol="";
        while(true){
            
            if(s.length()==0) break;
            
            int[] ct=new int[26];
            for(int i=0;i<s.length();i++)
                ct[s.charAt(i)-97]++;
            
            int p=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)<s.charAt(p)) p=i;
                if(--ct[s.charAt(i)-97]==0) break;
            }
            
            sol+=s.charAt(p);
            
            String tmp="";
            for(int i=p+1;i<s.length();i++)
                if(s.charAt(i)!=s.charAt(p))
                    tmp+=s.charAt(i);
            
            s=tmp;
        }
        
        return sol;
    }
}
