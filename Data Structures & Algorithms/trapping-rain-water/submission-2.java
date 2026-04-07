class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int water=0;
        int leftMax= 0;
        int rightMax= 0;
        // Using two pointer technique,
        while(l<=r){
            // at any time process the side with lower height.
            // smaller height limits water trapped.
            if(height[l]<height[r]){
                if(height[l] > leftMax){
                    leftMax=height[l];
                }else {
                    water += leftMax-height[l];
                }
                l++;
            } else {
                if(height[r] > rightMax){
                    rightMax=height[r];
                }else {
                    water += rightMax-height[r];
                }
                r--;
            }
        }
        return water;
    }
}
