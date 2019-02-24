/* https://leetcode.com/problems/generate-parentheses/ */

class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<String>();
        helper(sol, "", 0, 0, n);
        return sol;
    }
    
    public void helper(List<String> sol, String str, int op, int cl, int max){
        
        if(str.length() == max*2){
            sol.add(str);
            return;
        }
        
        if(op < max)
            helper(sol, str+"(", op+1, cl, max);
        if(cl < op)
            helper(sol, str+")", op, cl+1, max);
    }
}
