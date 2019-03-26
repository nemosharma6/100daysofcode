/* https://leetcode.com/problems/word-break-ii/ */
class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap());
    }
    
    public List<String> helper(String s, List<String> dict, Map<String, 
                                     List<String>> mp) {
        
        if(s.length()==0){
            List<String> l = new ArrayList();
            l.add("");
            return l;
        }
        
        if(mp.containsKey(s))
            return mp.get(s);
        
        List<String> l = new ArrayList();
        
        for(String w: dict){
            if(s.startsWith(w)){
                List<String> l1 = helper(s.substring(w.length()), dict, mp);
                for(String t: l1){
                    if(t.equals(""))
                        l.add(w);
                    else
                        l.add(w+" "+t);
                }
            }
        }
        
        mp.put(s, l);
        
        return l;
    }
}
