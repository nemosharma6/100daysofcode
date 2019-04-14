/* https://leetcode.com/problems/daily-temperatures/ */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] sol=new int[T.length];
        Stack<Integer> st=new Stack();
        for(int i=0;i<T.length;i++){
            if(st.isEmpty()) st.push(i);
            else {
                while(true){
                    if(st.isEmpty()) break;
                    int head=st.pop();
                    if(T[head]<T[i]) sol[head]=i-head;
                    else {
                        st.push(head);
                        break;
                    }
                }
                st.push(i);
            }
        }
        
        return sol;
    }
}
