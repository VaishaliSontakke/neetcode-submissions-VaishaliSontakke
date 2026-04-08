class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack1 = new LinkedList<>();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack1.push(s.charAt(i));
            } else {
                if(stack1.isEmpty()) {
                    return false;
                }
                    
                char c = stack1.pop();
                if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == ']') {
                    if((c == '(' && s.charAt(i) != ')') || (c == '[' && s.charAt(i) != ']')
                        || (c == '{' && s.charAt(i) != '}')){
                        return false;
                    }
            
                }
            }
        }
        if(stack1.isEmpty()){
            return true;
        }
        return false;
        
    }



}
