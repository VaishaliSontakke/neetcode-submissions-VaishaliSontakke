class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap1 = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(hmap1.containsKey(target-nums[i])){
                return new int[]{hmap1.get(target-nums[i]), i};
            } else {
                hmap1.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
