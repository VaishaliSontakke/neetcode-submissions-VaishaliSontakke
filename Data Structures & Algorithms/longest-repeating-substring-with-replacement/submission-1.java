class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> fmap = new HashMap<>();
        int l=0;
        int r=0;
        int maxf=0;
        int maxlen = 0;
        while(r < s.length()){
            int fm = fmap.getOrDefault(s.charAt(r), 0)+1;
            fmap.put(s.charAt(r),fm);
            if (maxf < fm){
                maxf = fm;
            }
            while((r-l+1)-maxf > k){
                int l1 = fmap.get(s.charAt(l));
                fmap.put(s.charAt(l),l1-1);
                if(l != s.length()-1){
                    l++;
                }
            }
            maxlen = Math.max(maxlen, (r-l+1));
            if(r == s.length()-1){
                break;
            }
            r++;
        }

    return maxlen;
    }
}
