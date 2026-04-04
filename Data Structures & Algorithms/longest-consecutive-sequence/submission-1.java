class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset1 = new HashSet<>();
        // put all elements in hashmap
        for(int i=0; i< nums.length; i++){
            if(!hset1.contains(nums[i])){
                hset1.add(nums[i]);
            }
        }
        int maxlen = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++){
            int tempSeq = 0;
            int key1 =  nums[i];

            if(!hset1.contains(key1-1)){
                while(hset1.contains(key1)){
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
