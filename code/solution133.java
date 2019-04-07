/* https://leetcode.com/problems/video-stitching/ */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        int c=0,st=0,en=0,p=0;
        for(int i=0;i<clips.length;c++){
            int mx=0;
            
            if(p>=T) break;
            
            while(st<clips.length && clips[st][0]<=p){
                if(mx<clips[st][1]){
                    mx=clips[st][1];
                    en=st;
                }
                st++;
            }
            
            p=mx;
            if(i==st) return -1;
            i=st;
        }
        
        if(p>=T) return c;
        else if(st<clips.length && clips[st][1]>=T) return c+1;
        else return -1;
    }
}
