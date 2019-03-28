/* https://leetcode.com/problems/remove-invalid-parentheses/ */
class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> sol = new ArrayList();
        char[] ch = {'(',')'};
        helper(s,0,0,sol,ch);
        return sol;
    }
    
    public void helper(String s, int pi, int pj, List<String> li, char[] ch){
        int c=0;
        for(int i=pi;i<s.length();i++){
            if(s.charAt(i)==ch[0])c++;
            if(s.charAt(i)==ch[1])c--;
            if(c>=0) continue;
            for(int j=pj;j<=i;j++)
                if(s.charAt(j)==ch[1] && (j==pj || s.charAt(j-1)!=ch[1]))
                    helper(s.substring(0,j)+s.substring(j+1),i,j,li,ch);
            
            return;
        }
        
        String t = new StringBuilder(s).reverse().toString();
        if(ch[0]=='(') {
            char[] chr = {')','('};
            helper(t,0,0,li,chr);
        } else
            li.add(t);
    }
    
}
