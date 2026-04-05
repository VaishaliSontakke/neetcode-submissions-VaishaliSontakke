
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
        for(int i=0; i < nums.length ; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int l=i+1, r = nums.length-1;
            while(l < r){
                int tempSum = nums[i] + nums[l] + nums[r];
                if(tempSum == 0){
                    ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    if(!result.contains(curr)){
                        result.add(curr);
                    }
                    l++; r--;
                } else if(tempSum < 0){
                    int lastL = nums[l];
                    l++; 
                    while(lastL == nums[l]){
                        l++;
                    }
                } else {
                    int lastR = nums[r];
                    r--;
                    while(lastR == nums[r]){
                        r--;
                    }
                }
                
            }
        }
       return result; 
    }
}
