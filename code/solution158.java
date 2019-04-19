/* https://leetcode.com/problems/lexicographical-numbers/ */
class Solution {
    List<Integer> sol=new ArrayList();
    boolean[] v;
    public List<Integer> lexicalOrder(int n) {
        v=new boolean[n+1]; 
        for(int i=1;i<=9;i++) rec(i,n,i);
        return sol;
    }
    
    public void rec(int curr, int num, int head){
        if(curr>num || v[curr] || (!v[curr/10] && curr>=10)) return;
        String t=new Integer(curr).toString();
        if(t.charAt(0)-'0'!=head) return;
        
        sol.add(curr);
        v[curr]=true;
        rec(curr*10,num,head);
        rec(curr+1,num,head);
    }
}
