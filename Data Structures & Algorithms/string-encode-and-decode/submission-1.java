class Solution {

    public String encode(List<String> strs) {
        // len#stringlen#string
        // 4#neet4#code
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < strs.size(); i++){
            sb.append(String.valueOf(strs.get(i).length()));
            sb.append('#');
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        // get string find length, find string, append to list
        int i = 0;
        char[] chars = str.toCharArray();
        while(i < chars.length){
            // i points to int
            int j = i;
            while(chars[j] != '#'){
                j++;
            }
            // j ends at '#'
            int lengthSub = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j+1, j+1+lengthSub));
            i = j+1+lengthSub;
        }
        return res;
    }
}
