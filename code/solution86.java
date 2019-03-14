/* https://leetcode.com/problems/longest-repeating-character-replacement/ */
class Solution {
    public int characterReplacement(String s, int k) {
        
        int ch[] = new int[26];
        int sol=0;
        
        for(int i=0;i<s.length();i++){
            
            for(int j=0;j<26;j++)
                ch[j]=0;
            
            for(int j=i;j<s.length();j++){
                ch[s.charAt(j)-65]+=1;
                int mx = max(ch);
                if(mx+k>=j-i+1 && j-i+1>sol)
                    sol=j-i+1;
            }
        }
        
        return sol;
    }
    
    public int max(int a[]){
        int mx=0;
        for(int i=0;i<a.length;i++)
            mx=Math.max(mx, a[i]);
        return mx;
    }
}
