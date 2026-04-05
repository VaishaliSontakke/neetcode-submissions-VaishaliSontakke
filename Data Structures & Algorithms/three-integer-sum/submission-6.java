
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 3){
            return result;
        }
        if(nums.length == 3){
            if(nums[0] + nums[1] + nums[2] == 0){
                ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(nums[0], nums[1], nums[2]));
                result.add(curr);    
            }
            return result;
        }
        
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> hmap1 = new HashMap<>();
        for(int i=0; i < nums.length ; i++){
            int rem = 0 - nums[i];
            for(int j=i+1; j < nums.length ; j++){
                //if ( nums[i] != 0 && nums[j] == nums[i]){
                //    continue;
                //}
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
