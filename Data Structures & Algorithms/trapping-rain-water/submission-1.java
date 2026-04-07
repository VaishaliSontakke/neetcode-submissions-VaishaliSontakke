class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int water=0;
        int leftMax= Integer.MIN_VALUE;
        int rightMax= Integer.MIN_VALUE;
        // Using two pointer technique,
        while(l<=r){
            // at any time process the side with lower height.
            // smaller height limits water trapped.
            if(height[l]<height[r]){
                if(height[l] > leftMax){
                    leftMax=Math.max(height[l], leftMax);
                }else {
                    water += leftMax-height[l];
                }
                l++;
            } else {
                if(height[r] > rightMax){
                    rightMax=Math.max(height[r], rightMax);
                }else {
                    water += rightMax-height[r];
                }
                r--;
            }
        }
        return water;
    }
}
