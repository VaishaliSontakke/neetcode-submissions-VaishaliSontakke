class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l=0;
        int maxf=0;
        int maxlen = 0;
        for(int r=0; r < s.length(); r++){
            int idx = s.charAt(r)- 'A'; 
            freq[idx] = freq[idx]+1;
            maxf =Math.max(freq[idx], maxf);
            while((r-l+1)-maxf > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxlen = Math.max(maxlen, (r-l+1));
        }

    return maxlen;
    }
}
