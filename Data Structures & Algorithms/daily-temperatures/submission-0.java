class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] result = new int[temp.length];
        st.push(0);
        for(int i=1; i< temp.length; i++){
            while( !st.isEmpty() && temp[i] > temp[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            result[st.pop()] = 0;
        }
        return result;
    }
}
