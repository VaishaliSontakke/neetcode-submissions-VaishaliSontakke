class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int l=0, r=0;
        int s1len = s1.length();
        char[] anaS1 = s1.toCharArray();
        Arrays.sort(anaS1);
        while(r < s2.length()-s1len+1){
            if(s1.indexOf(s2.charAt(r)) != -1){
                char[] anaSubS2 = s2.substring(r,r+s1len).toCharArray();
                Arrays.sort(anaSubS2);
                if(Arrays.equals(anaS1, anaSubS2)){
                    return true;
                }
            }
            r = r+1;
        }
        return false;        
    }
}
