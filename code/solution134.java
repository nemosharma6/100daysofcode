/* https://leetcode.com/problems/combination-sum-ii/ */
class Solution {
    
    List<List<Integer>> sol=new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sum(candidates,target,0,new ArrayList(),0);
        return sol;
    }
    
    public void sum(int[] c, int t, int s, List<Integer> li, int j){
        if(s==t){
            sol.add(new ArrayList(li));
            return;
        }
        
        if(s>t) return;
        for(int i=j;i<c.length;i++){
            if(i>j && c[i]==c[i-1]) continue;
            li.add(c[i]);
            sum(c,t,s+c[i],li,i+1);
            li.remove(li.size()-1);
        }
    }
}
