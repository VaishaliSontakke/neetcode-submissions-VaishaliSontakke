class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r= nums.length-1;

        // Edge case 1: array is not rotated 
        if(nums[l] <= nums[r]){
            return nums[l];
        }

        while(l<=r){
            int mid = l+ (r-l)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            } else if(nums[mid] >= nums[r]){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return nums[0];

        
    }
}
