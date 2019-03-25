/* https://leetcode.com/problems/split-array-into-fibonacci-sequence/  */
class Solution {
    
    List<Integer> sol = new ArrayList();
    public List<Integer> splitIntoFibonacci(String S) {
        check(S, 0, new ArrayList());
        return sol;
    }
    
    public boolean check(String s, int i, List<Integer> l){
        
        if(i==s.length() && l.size()>=3){
            sol = l;
            return true;
        }
        
        if(i==s.length())
            return false;
        
        for(int j=i;j<s.length();j++){
            String tmp = s.substring(i,j+1);
            if(tmp.startsWith("0") && tmp.length()>1)
                continue;
            
            if(isAnInt(tmp))
                return false;
            
            if(l.size()<2){
                l.add(Integer.parseInt(tmp));
                boolean b = check(s,j+1,l);
                if(b) return true;
                l.remove(l.size()-1);
            } else {
                int a = l.get(l.size()-2);
                int b = l.get(l.size()-1);
                int t = Integer.parseInt(tmp);
                if(t == a+b){
                    l.add(t);
                    boolean status = check(s,j+1,l);
                    if(status) return status;
                    l.remove(l.size()-1);
                }
            }
        }
        
        return false;
    }
    
    public boolean isAnInt(String a){
        try {
            int t = Integer.parseInt(a);
        } catch(Exception E){
            return true;
        }
        
        return false;
    }
}
