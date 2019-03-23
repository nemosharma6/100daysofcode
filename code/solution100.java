/* https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/ */
class Solution {
    public int countTriplets(int[] A) {
        
        Map<Integer, Integer> mp = new HashMap();
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A.length;j++){
                int tmp = A[i] & A[j];
                if(mp.containsKey(tmp))
                    mp.put(tmp, mp.get(tmp)+1);
                else
                    mp.put(tmp, 1);
            }
        
        int ct=0;
        for(Map.Entry<Integer, Integer> e: mp.entrySet()){
            for(int i=0;i<A.length;i++){
                int tmp = e.getKey() & A[i];
                if(tmp==0)
                    ct+=e.getValue();
            }
        }
        
        return ct;
    }
}
