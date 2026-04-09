public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() { return first; }
    public S getSecond() { return second; }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair<Integer,Integer>> st = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;
        // put the index and height pair in stack.
        // if existing height rectangle is broken, current height is low.
        // find its max area. by popping. also for every popped element
        // keep last index. so current bar can be extended back.
        // if nothing to pop , push current index and height to stack.
        Pair<Integer, Integer> p1 = new Pair(0, heights[0]);
        st.push(p1);
        for(int i=1; i< heights.length; i++){
            int idx=i, h1=0;
            while(!st.isEmpty() && heights[i] < st.peek().getSecond()){
                Pair<Integer,Integer> pair1 = st.pop();
                idx = pair1.getFirst();
                h1 = pair1.getSecond();
                maxArea= Math.max(maxArea , h1*(i-idx));
            }
            st.push(new Pair(idx,heights[i]));
        }

        // at last some smaller heights can go all the way till end.
        // no rectagle break was found for this. calculate area of this
        // based on length of array. and update max area.
        while(!st.isEmpty()){
            Pair<Integer,Integer> pair1 = st.pop();
            int height1 = pair1.getSecond();
            int index1 = pair1.getFirst();
            maxArea=Math.max(maxArea, height1 * (heights.length - index1));
        }
        return maxArea;
    }
}
