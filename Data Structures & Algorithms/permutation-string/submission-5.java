class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // get sorted array of s1 chars.
        int i=0;
        char[] anaS1 = s1.toCharArray();
        int s1len = anaS1.length;
        Arrays.sort(anaS1);
        while(i < s2.length()-s1len+1){
            // check index of s2's char in s1.
            if(s1.indexOf(s2.charAt(i)) != -1){
                // get substring of same length of s1 from start r, and sort it. 
                char[] anaSubS2 = s2.substring(i,i+s1len).toCharArray();
                Arrays.sort(anaSubS2);
                if(Arrays.equals(anaS1, anaSubS2)){
                    return true;
                }
            }
            i++;
        }
        return false;        
    }
}
