/* https://leetcode.com/problems/longest-valid-parentheses/ */
class Solution {
    
    public int longestValidParentheses(String s) {    
        int[] op=new int[s.length()+1];
        int[] cl=new int[s.length()+1];
        for(int i=1;i<=s.length();i++) {
            if(s.charAt(i-1)=='(') {
                op[i]=op[i-1]+1;
                cl[i]=cl[i-1];
            } else {
                cl[i]=cl[i-1]+1;
                op[i]=op[i-1];
            }
        }
        
        int sol=0;
        Map<Integer, Integer> mp=new HashMap();
        mp.put(0,0);
        for(int i=1;i<=s.length();i++){
            if(s.charAt(i-1)==')' && mp.containsKey(op[i]-cl[i])){
                int val=mp.get(op[i]-cl[i]);
                sol=Math.max(i-val, sol);
            } else
                mp.put(op[i]-cl[i], i);
        }
        
        return sol;
    }
}
