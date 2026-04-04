class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, List<Integer>> hmap1 = new HashMap<>();
        // put all elements in hashmap
        for(int i=0; i< nums.length; i++){
            if(!hmap1.containsKey(nums[i])){
                hmap1.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            } else {
                hmap1.get(nums[i]).add(i);
            }
        }
        int maxlen = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++){
            int tempSeq = 0;
            int key1 =  nums[i];

            if(hmap1.containsKey(key1) && !hmap1.containsKey(key1-1)){
                while(hmap1.containsKey(key1)){
                    tempSeq++;
                    maxlen = Math.max(tempSeq, maxlen);
                    key1++;
                }
            }
        }
        if(maxlen == Integer.MIN_VALUE){
            return 0;
        }
        return maxlen;
        
    }
}
