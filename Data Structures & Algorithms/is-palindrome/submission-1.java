class Solution {
    public boolean isPalindrome(String s) {
        String str1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l=0,r=str1.length()-1;
        while(l<=r){
            if(str1.charAt(l) != str1.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
