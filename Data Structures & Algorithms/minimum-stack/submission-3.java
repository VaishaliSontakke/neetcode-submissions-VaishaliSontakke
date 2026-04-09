class MinStack {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public MinStack() {
        // ArrayDeque stacks are better than linkedlist
         s1 = new ArrayDeque<>();
         s2 = new ArrayDeque<>();
    }
    
    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty()){
            s2.push(val);
            return;    
        }
        if(val<=s2.peek()){
            s2.push(val);
        }
        
    }
    
    public void pop() {
        if(s1.isEmpty()){
            return;
        }
        int val = s1.pop();
        if(!s2.isEmpty() && s2.peek() == val){
            s2.pop();
        }
    }
    
    public int top() {
        if(s1.isEmpty()){
            return -1;
        }
        return s1.peek();
        
    }
    
    public int getMin() {
        if(s2.isEmpty()){
            return -1;
        }
        return s2.peek();
    }
}
