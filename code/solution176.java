/* https://leetcode.com/problems/reveal-cards-in-increasing-order/ */
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length==0) return deck;
        List<Integer> li=new ArrayList();
        for(int i=0;i<deck.length;i++) li.add(i);
        Arrays.sort(deck);
        int[] sol=new int[deck.length];
        int j=0;
        while(li.size()!=0){
            sol[li.get(0)]=deck[j++];
            li.remove(0);
            if(li.size()==0) break;
            int next=li.get(0);
            li.remove(0);
            li.add(next);
        }
        return sol;
    }
}
