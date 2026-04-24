class Solution {
    // no of way to reach stair n = way(n-1) + ways(n-2)
    // similar to fibonacci but start condition f(2) = 2
    //bases cases are little different
    // using bottom up optimized memory solution. tabulation (bottom up)
    // full DP array is not need only two prev values are stored.

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int prev2 = 1,  prev=2, curr =0;
        for(int i=3; i<=n;i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
        
    }
}
