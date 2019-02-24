/* https://leetcode.com/problems/generate-parentheses/ */

class Solution {
    
    public List<String> generateParenthesis(int n) {
    
        Set<String> st = new HashSet();
        List<String> sol = new ArrayList();
        helper(new Stack<Character>(), n, st, new StringBuilder());
        for(String i: st) sol.add(i);
        
        return sol;
    }
    
    public void helper(Stack<Character> s, int n, Set<String> st, StringBuilder sb){
        
        if(n == 0 && s.isEmpty()){
            st.add(sb.toString());
            return;
        }
        
        if(n == 0) {
            s.pop();
            sb.append(')');
            helper(s,n,st,sb);
            sb.deleteCharAt(sb.length() - 1);
            s.push('(');            
            return;
        }
        
        if(!s.isEmpty()){
            s.pop();
            sb.append(')');
            helper(s,n,st,sb);
            sb.deleteCharAt(sb.length() - 1);
            s.push('(');
        }
        
        s.push('(');
        sb.append('(');
        helper(s,n-1,st,sb);
        
        s.pop();
        sb.append(')');
        helper(s,n-1,st,sb);
        
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        
    }
}
