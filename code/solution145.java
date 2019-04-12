/* https://leetcode.com/problems/combinations/ */
class Solution {
    List<List<Integer>> sol=new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        rec(n,k,1,new ArrayList());
        return sol;
    }
    
    public void rec(int n, int k, int j, List<Integer> li){
        if(li.size()==k){
            sol.add(new ArrayList(li));
            return;
        }
        
        for(int i=j;i<=n;i++){
            li.add(i);
            rec(n,k,i+1,li);
            li.remove(li.size()-1);
        }
    }
}
