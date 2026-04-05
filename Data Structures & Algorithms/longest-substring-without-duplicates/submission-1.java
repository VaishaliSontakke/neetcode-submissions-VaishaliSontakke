class Solution {
    public int lengthOfLongestSubstring(String s) {
    int l =0;
    HashMap<Character, Integer> charsVisited = new HashMap<>();
    int maxLen = 0;
    for(int r=0; r < s.length(); r++){
        while( l< r && charsVisited.containsKey(s.charAt(r))){
            charsVisited.remove(s.charAt(l));
            l++;
        }
        charsVisited.put(s.charAt(r), r);
        maxLen = Math.max(r-l+1, maxLen);
        }
    return maxLen;   
    }
}
