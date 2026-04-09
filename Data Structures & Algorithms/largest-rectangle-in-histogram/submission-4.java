
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> st = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;
        // put the index and height array in stack.
        // if existing height(higher) rectangle is broken, current height is low.
        // find its max area. by popping. also for every popped element
        // keep last index. so current bar can be extended back.
        // if nothing to pop , push current index and height to stack.
        st.push(new int[]{0, heights[0]});
        for(int i=1; i< heights.length; i++){
            int idx=i, h1=0;
            while(!st.isEmpty() && heights[i] < st.peek()[1]){
                int[] pair1 = st.pop();
                idx = pair1[0];
                h1 = pair1[1];
                maxArea= Math.max(maxArea , h1*(i-idx));
            }
            st.push(new int[]{idx,heights[i]});
        }

        // at last some smaller heights can go all the way till end to get area.
        // no rectagle break was found for this. calculate area of this
        // based on length of array. and update max area.
        while(!st.isEmpty()){
            int[] pair1 = st.pop();
            int index1 = pair1[0];
            int height1 = pair1[1];
            maxArea=Math.max(maxArea, height1 * (heights.length - index1));
        }
        return maxArea;
    }
}
