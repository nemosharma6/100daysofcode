/* https://leetcode.com/problems/lexicographical-numbers/ */
class Solution {
    List<Integer> sol=new ArrayList();
    boolean[] v;
    public List<Integer> lexicalOrder(int n) {
        v=new boolean[n+1]; 
        rec(1,n);
        return sol;
    }
    
    public void rec(int curr, int num){
        if(curr>num || v[curr] || (!v[curr/10] && curr>=10)) return;
        sol.add(curr);
        v[curr]=true;
        rec(curr*10,num);
        rec(curr+1,num);
    }
}
