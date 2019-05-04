/* https://leetcode.com/problems/path-sum-ii/ */
class Solution {
    List<List<Integer>> sol=new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        rec(root,0,sum,new ArrayList());
        return sol;
    }
    
    public void rec(TreeNode root, int s, int sum, List<Integer> li){
        if(root==null) return;
        if(root.left==null && root.right==null && s+root.val==sum){
            li.add(root.val);
            sol.add(new ArrayList(li));
            li.remove(li.size()-1);
            return;
        }
        
        li.add(root.val);
        rec(root.left, s+root.val, sum, li);
        rec(root.right, s+root.val, sum, li);
        li.remove(li.size()-1);
    }
}
