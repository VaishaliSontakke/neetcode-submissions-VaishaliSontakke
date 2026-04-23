class Solution {
    public int jump(int[] nums) {
        int l=0, r=0; 
        
        int jumps =0;
        // expand window till we reach last index.
        while(r < nums.length -1){
            int farthest = 0;
            // find farthest points in the range if we try to reach for values between l and r
            for(int i=l; i<=r ; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r+1;
            r = farthest;
            jumps +=1;
        }
        return jumps;
        
    }
}
