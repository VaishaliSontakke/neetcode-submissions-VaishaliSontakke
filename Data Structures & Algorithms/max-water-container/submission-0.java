class Solution {
    public int maxArea(int[] heights) {
        int l=0, r = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(l<r){
            int tempArea = (r-l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(tempArea, maxArea);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
        
    }
}
