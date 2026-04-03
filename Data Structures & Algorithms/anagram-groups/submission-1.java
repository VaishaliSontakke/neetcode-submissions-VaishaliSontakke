class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap1 = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i < strs.length; i++){
            char[] ana = strs[i].toCharArray();
            Arrays.sort(ana);
            String anaString =  new String(ana);
            if(hmap1.containsKey(anaString)){
                hmap1.get(anaString).add(strs[i]);
            } else {
                hmap1.put(anaString, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        for (List<String> vals : hmap1.values()){
            result.add(vals);
        }
        return result;
        
    }
}
