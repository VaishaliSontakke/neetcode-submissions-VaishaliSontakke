class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap1 = new HashMap<>();
        for(int i=0; i< nums.length ; i++){
                hmap1.put(nums[i], hmap1.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->
        hmap1.get(b) - hmap1.get(a));
        pq.addAll(hmap1.keySet());

        int[] topK = new int[k];
        for(int i=0; i< k ; i++){
            topK[i] = pq.poll();
        }

        return topK;

    }
}
