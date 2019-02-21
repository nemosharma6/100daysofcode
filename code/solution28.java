/* https://leetcode.com/problems/decode-string/ */

class Solution {
    public String decodeString(String s) {
        
        if(s.length() == 0) return "";
        
        while(true){
            
            int open, close;
            open = close = -1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '[') open = i;
                if(s.charAt(i) == ']') {
                    close = i;
                    break;
                }
            }
            
            if(open == -1) break;
            String word = s.substring(open+1, close);
            
            StringBuilder c = new StringBuilder();
            int j = open - 1;
            char ch = s.charAt(j);
            while(ch-'0' >= 0 && ch-'0' <= 9){
                c.insert(0, ch);
                j--;
                if(j<0) break;
                ch = s.charAt(j);
            }
            
            int ct = Integer.parseInt(c.toString());
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<ct;i++) sb.append(word);
            
            s = s.substring(0, j+1) + sb.toString() + s.substring(close+1);
        }
        
        return s;
        
    }
}
