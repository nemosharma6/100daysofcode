/**
 https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st=new Stack();
        List<Integer> sol=new ArrayList();
        Set<TreeNode> set=new HashSet();
        if(root==null) return sol;
        st.push(root);
        set.add(root);
        while(!st.isEmpty()){
            TreeNode node=st.peek(), le=node.left, ri=node.right;
            if(le==null && ri==null){
                sol.add(node.val);
                st.pop();
            } else {
                
                boolean r=true, l=true;
                if(ri!=null && !set.contains(ri)){
                    st.push(ri);
                    set.add(ri);
                    r=false;
                }
                
                if(le!=null && !set.contains(le)){
                    st.push(le);
                    set.add(le);
                    l=false;
                }
                
                if(l && r){
                    sol.add(node.val);
                    st.pop();
                }
            }
        }
        
        return sol;
    }
}
