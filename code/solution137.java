/* https://leetcode.com/problems/permutations-ii/ */
class Solution {
    
    List<List<Integer>> sol=new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        rec(nums,new ArrayList(),new boolean[nums.length]);
        return sol;
    }
    
    public void rec(int[] n, List<Integer> li, boolean[] v){
        
        if(li.size()==n.length){
            sol.add(new ArrayList(li));
            return;
        }
        
        for(int i=0;i<n.length;i++){
            if(v[i]) continue;
            if(i>0 && n[i-1]==n[i] && !v[i-1]) continue;
            li.add(n[i]);
            v[i]=true;
            rec(n,li,v);
            li.remove(li.size()-1);
            v[i]=false;
        }
    }
}
