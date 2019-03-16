/* https://leetcode.com/problems/powx-n/ */
class Solution {
    public double myPow(double x, int n) {
        
        if(n==0 || x==1)
            return 1.0;
        
        if(n==Integer.MIN_VALUE){
            if(x==-1) return 1.0;
            return 0.0;
        }
        
        if(n>0)
            return pos(x,n);
        else
            return neg(x,-1*n);
        
    }
    
    public double pos(double x, long n){
        
        if(n==1)
            return x;
        
        if(n%2==0){
            double tmp = pos(x, n/2);
            return tmp*tmp;
        } else {
            double tmp = pos(x, n/2);
            return tmp*tmp*x;
        }
    }
    
    public double neg(double x, long n){
        
        if(n==1)
            return 1.0/x;
        
        if(n%2==0){
            double tmp = neg(x, n/2);
            return tmp*tmp;
        } else {
            double tmp = neg(x, n/2);
            return tmp*tmp/x;
        }
    }
}
