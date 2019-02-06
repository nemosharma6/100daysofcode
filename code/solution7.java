// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums.length == 0) return new int[0];
        if(k == 1) return nums;
        if(k >= nums.length){
            int mx = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++)
                if(nums[i] > mx)
                    mx = nums[i];
            
            int ar[] = {mx};
            return ar;
        }
        
        Deque<Integer> dq = new LinkedList<Integer>();
        
        for(int i=0;i<k;i++){
            if(i == 0)
                dq.addLast(i);
            else{
                while(dq.peekLast() != null && nums[dq.peekLast()] < nums[i]) dq.removeLast();
                dq.addLast(i);
            }
        }
        
        int ar[] = new int[nums.length-k+1];
        for(int i=k;i<nums.length;i++){
            
            ar[i-k] = nums[dq.peekFirst()];
            while(dq.peekFirst() <= i-k){
                dq.removeFirst();
            }
            
            while(dq.peekLast() != null && nums[dq.peekLast()] < nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        
        ar[nums.length-k] = nums[dq.peekFirst()]; 
        return ar;
    }
}