/* https://leetcode.com/problems/shortest-palindrome/ */
class Solution {
    public String shortestPalindrome(String s) {
        
        for(int i=s.length()-1;i>=0;i--){
            if(isPal(0,i,s)){
                StringBuilder sb=new StringBuilder(s.substring(i+1));
                return sb.reverse()+s;
            }
        }
        
        return s;
    }
    
    public boolean isPal(int l, int r, String s){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;r--;
        }
        
        return true;
    }
}
