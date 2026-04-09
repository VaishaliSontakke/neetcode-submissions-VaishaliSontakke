public class Pair<F, S> {
    private final F first;
    private final S second;

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

        while(!st.isEmpty()){
            Pair<Integer,Integer> pair1 = st.pop();
            int height1 = pair1.getSecond();
            int index1 = pair1.getFirst();
            maxArea=Math.max(maxArea, height1 * (heights.length - index1));
        }
        return maxArea;
    }
}
