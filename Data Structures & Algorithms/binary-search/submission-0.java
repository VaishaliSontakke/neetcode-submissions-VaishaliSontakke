class Solution {
    public int search(int[] nums, int target) {
        // 0 1 2 3 4 5
        //-1,0,2,4,6,8
        // 
        int l=0, r = nums.length-1;
        while(l<=r){
            int mid = (l + r)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
        
    }
}
