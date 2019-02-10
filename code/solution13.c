// https://leetcode.com/problems/maximum-product-subarray/

int maxProduct(int* nums, int numsSize) {
    
    int num = nums[0];
    int mx = num;
    int mn = num;
    
    for(int i = 1; i < numsSize; i++){
        int t1 = mx;
        int t2 = mn;
        mx = max(max(nums[i], t1*nums[i]), t2*nums[i]);
        mn = min(min(nums[i], t1*nums[i]), t2*nums[i]);
        num = max(num, mx);
    }
    
    return num;
}

int max(int a, int b){
    if(a > b) return a; else return b;
}

int min(int a, int b){
    if(a > b) return b; else return a;
}
