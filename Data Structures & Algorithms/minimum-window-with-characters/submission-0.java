class Solution {
    public String minWindow(String s, String t) {
        int[] presence = new int[128];
        int[] need = new int[128];
        int low=0;
        int minlen = Integer.MAX_VALUE;
        int minL= 0;
        
        for(int i=0; i< t.length(); i++){
            char c  = t.charAt(i);
            need[c]++; 
        }
        int required = t.length();
        int right = 0;
        while(right < s.length()){
            char c1 = s.charAt(right);
            if(need[c1] > 0  && need[c1] > presence[c1]){
                required--;
            }
            presence[c1]++;
            right++;
            while(required == 0){
                if(right-low < minlen){
                    minlen = right-low;
                    minL = low;
                }
                char evict = s.charAt(low);
                presence[evict]--;
                if(need[evict] > 0 && presence[evict] < need[evict]){
                    required++;
                }
                low++;
            }
        }
        if(minlen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minL, minL+minlen);
}
}
