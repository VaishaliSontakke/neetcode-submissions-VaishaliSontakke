
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
                    while(nums[l] == nums[l-1] && l<r){
                        l++;
                    }
                    while(nums[r] == nums[r+1] && l<r){
                        r--;
                    }
                } else if(tempSum < 0){
                    l++;
                    while(nums[l] == nums[l-1] && l<r){
                        l++;
                    }
                } else {
                    r--;
                    while(nums[r] == nums[r+1] && l<r){
                        r--;
                    }
                }
                
            }
        }
       return result; 
    }
}
