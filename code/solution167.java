/* https://leetcode.com/problems/sliding-window-median/ */
class Solution {
    
    class Median {
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;
        public Median(int k){
            max=new PriorityQueue(k, Collections.reverseOrder());
            min=new PriorityQueue(k);
        }
        
        public void offer(int num){
            max.offer(num);
            min.offer(max.poll());
            if(max.size()<min.size())
                max.offer(min.poll());
        }
        
        public boolean remove(int num){
            return max.remove(num) || min.remove(num);
        }
        
        public double median(){
            return max.size()>min.size()?max.peek():max.peek()*0.5+min.peek()*0.5;
        }
        
        public int size(){
            return max.size()+min.size();
        }
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        Median med=new Median(k);
        double[] d=new double[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            med.offer(nums[i]);
            if(med.size()==k){
                d[i-k+1]=med.median();
                med.remove(nums[i-k+1]);
            }
        }
        
        return d;
    }
}
