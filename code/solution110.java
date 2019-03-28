/* https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/ */
class Solution {
    public int longestSubstring(String s, int k) {
        
        if(s.length()<k)
            return 0;
        
        int[] c = new int[26];
        int min=Integer.MAX_VALUE;
        char ch=' ';
        
        for(int i=0;i<s.length();i++)
            c[s.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++){
            if(c[i]>0 && c[i]<min){
                min=c[i];
                ch=(char)(i+97);
            }
        }
        
        if(min>=k)
            return s.length();
        
        String[] l = s.split(String.valueOf(ch));
        int mx=0;
        for(int i=0;i<l.length;i++){
            int t=longestSubstring(l[i], k);
            mx=Math.max(mx, t);
        }
        
        return mx;
    }
}
