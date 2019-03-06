/* https://leetcode.com/problems/permutations/ */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList();
        
        List<Integer> num = new ArrayList();
        for(int i=0;i<nums.length;i++)
            num.add(nums[i]);
        
        rec(num, sol, new ArrayList());
        return sol;
    }
    
    public void rec(List<Integer> nums, List<List<Integer>> sol, List<Integer> t){
        
        if(nums.size() == 0){
            sol.add(new ArrayList(t));
            return;
        }
        
        for(int i=0;i<nums.size();i++){
            int tmp = nums.get(i);
            t.add(tmp);
            nums.remove(i);
            rec(nums, sol, t);
            t.remove(t.size()-1);
            nums.add(i, tmp);
        }
        
    }
}
