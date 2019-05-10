/* https://leetcode.com/problems/orderly-queue/ */
class Solution {
    public String orderlyQueue(String S, int K) {
        String prev=S, best=S;
        if(K==1){
            while(true){
                int mx=0, ind=0;
                for(int i=0;i<K;i++){
                    if((int)prev.charAt(i)>mx) {
                        mx=(int)prev.charAt(i);
                        ind=i;
                    }
                }
                String tmp=prev.substring(0,ind)+prev.substring(ind+1)+prev.charAt(ind);
                if(tmp.equals(S)) return best;
                best=(tmp.compareTo(best)<0)?tmp:best;
                prev=tmp;
            }
        }
        
        char[] ch=S.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
