
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> hmap1 = new HashMap<>();
        for(int i=0; i < nums.length ; i++){
            int rem = 0 - nums[i];
            for(int j=i+1; j < nums.length ; j++){
                if(hmap1.containsKey(rem-nums[j])){
                    ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(nums[i], nums[j], rem - nums[j]));
                    if(!result.contains(curr)){
                      result.add(curr);
                    }
                }
            }    
            hmap1.put(nums[i], i); 
        }
       return result; 
    }
}
