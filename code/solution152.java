/**
 https://leetcode.com/problems/all-possible-full-binary-trees/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<Integer,List<TreeNode>> mp=new HashMap();
    public List<TreeNode> allPossibleFBT(int N) {
        return helper(N);
    }
    
    public List<TreeNode> helper(int n){
        List<TreeNode> sol=new ArrayList();
        if(n==1){
            sol.add(new TreeNode(0));
            return sol;
        }
        
        if(mp.containsKey(n)) 
            return mp.get(n);
        
        n--;
        for(int i=1;i<n;i+=2){
            List<TreeNode> l=helper(i);
            List<TreeNode> r=helper(n-i);
            for(TreeNode l1:l)
                for(TreeNode r1:r){
                    TreeNode tmp=new TreeNode(0);
                    tmp.left=l1;
                    tmp.right=r1;
                    sol.add(tmp);
                }
        }
        
        mp.put(n+1,sol);
        return sol;
    }
}
