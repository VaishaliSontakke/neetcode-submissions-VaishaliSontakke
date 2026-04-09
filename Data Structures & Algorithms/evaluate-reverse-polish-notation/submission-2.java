class Solution {
    public int evalRPN(String[] tokens) {
        // 1 2 + 3 * 4 -
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i=0; i < tokens.length; i++){
            String c = tokens[i];
            
            switch(c){
                case "+":
                    if(!st.isEmpty()){
                        int second = st.pop();
                        int first = 0;
                        if(!st.isEmpty()){
                            first = st.pop();
                        }
                        st.push(first+second);
                    }
                    break;
                case "-":
                    if(!st.isEmpty()){
                        int second = st.pop();
                        int first = 0;
                        if(!st.isEmpty()){
                            first = st.pop();
                        }
                        st.push(first-second);
                    }
                    break;
                case "*":
                    if(!st.isEmpty()){
                        int second = st.pop();
                        int first = 0;
                        if(!st.isEmpty()){
                            first = st.pop();
                        }
                        st.push(first*second);
                    }
                    break;
                case "/":
                    if(!st.isEmpty()){
                        int second = st.pop();
                        int first = 1;
                        if(!st.isEmpty()){
                            first = st.pop();
                        }
                        st.push(first/second);
                    }
                    break;
                default:
                    st.push(Integer.parseInt(c));
                    break;

            }

        }
        if(!st.isEmpty()){
            return st.pop();
        }
        return -1;
        
    }
}
