/* https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */

class Solution {
    public List<String> letterCombinations(String digits) {
        String ar[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> l = new ArrayList();
        helper(digits, 0, ar, new StringBuilder(), l);
        return l;
    }
    
    public void helper(String dig, int j, String[] map, StringBuilder sb, List<String> sol){
        
        if(j == dig.length()){
            if(j > 0) sol.add(sb.toString());
            return;
        }
        
        String tmp = map[dig.charAt(j)-'2'];
        for(int i=0;i<tmp.length();i++){
            sb.append(tmp.charAt(i));
            helper(dig, j+1, map, sb, sol);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
