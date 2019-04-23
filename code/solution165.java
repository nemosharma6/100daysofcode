/* https://leetcode.com/problems/clumsy-factorial/ */
class Solution {
    public int clumsy(int N) {
        List<String> l=new ArrayList();
        Stack<String> st=new Stack();
        int s=0,c=1;
        for(int i=N;i>1;i--){
            l.add(String.valueOf(i));
            if(c==1) l.add("*");
            else if(c==2) l.add("/");
            else if(c==3) l.add("+");
            else l.add("-");
            c++;
            if(c==5) c=1;
        }
        
        l.add("1");
        
        for(int i=0;i<l.size();i++){
            if(l.get(i).equals("*") || l.get(i).equals("/")){
                int num=Integer.parseInt(st.pop());
                int nxt=Integer.parseInt(l.get(i+1));
                if(l.get(i).equals("*")) st.push(String.valueOf(num*nxt));
                else if(l.get(i).equals("/")) st.push(String.valueOf((int)num/nxt));
                i++;
            } else
                st.push(l.get(i));
        }
        
        List<String> tmp=new ArrayList();
        while(!st.isEmpty()) tmp.add(0,st.pop());
        for(int i=0;i<tmp.size();i++){
            if(tmp.get(i).equals("+")) s+=Integer.parseInt(tmp.get(i+1)); 
            else if(tmp.get(i).equals("-")) s-=Integer.parseInt(tmp.get(i+1));
            else {
                s=Integer.parseInt(tmp.get(i));
                continue;
            }
            i++;
        }
        
        return s;
    }
}
