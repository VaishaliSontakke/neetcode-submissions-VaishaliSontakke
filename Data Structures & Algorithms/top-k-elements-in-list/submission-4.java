class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap1 = new HashMap<>();
        for(int i=0; i< nums.length ; i++){
                hmap1.put(nums[i], hmap1.getOrDefault(nums[i], 0)+1);
        }

        // priority Queue with descending order
        /*PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->
        hmap1.get(b) - hmap1.get(a));
        // add all keys to priority queue, order based on above
        pq.addAll(hmap1.keySet());

        int[] topK = new int[k];
        for(int i=0; i< k ; i++){
            topK[i] = pq.poll();
        }*/

        // if [7,7 ] the value 7 occures 2 times so buckets should 3 to include 2 end value
        List<Integer>[] buckets = new List[nums.length + 1];
        for(Integer key: hmap1.keySet()){
            int freq = hmap1.get(key);
            if(buckets[freq] == null){
                buckets[freq]= new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int count = 0;
        int[] topK = new int[k];
        for(int i=nums.length; i>=0; i--){
            if(buckets[i] != null && count < k){
                int len1 = buckets[i].size()-1;
                while(len1 >= 0 && count < k){
                    topK[count++] = buckets[i].get(len1);
                    len1--;
                }
            }
            if(count >= k){
                break;
            }

        }

        return topK;

    }
}