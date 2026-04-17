class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l=0;
        int maxf=0;
        int maxlen = 0;
        // sliding window keep on incr. store max freq.
        // sqeeze window if lenWindow-maxf > k, -'A' from character gives int equivalent.
        for(int r=0; r < s.length(); r++){ 
            freq[s.charAt(r)- 'A']++;
            maxf = Math.max(freq[s.charAt(r)-'A'], maxf);
            // if or while any works
            if((r-l+1)-maxf > k){
                // reduce the frequency, and increment l
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxlen = Math.max(maxlen, (r-l+1));
        }

    return maxlen;
    }
}
