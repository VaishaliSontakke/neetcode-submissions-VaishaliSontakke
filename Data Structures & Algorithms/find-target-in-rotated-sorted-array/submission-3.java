class Solution {
    public int search(int[] nums, int target) {
        int k = findPivot(nums,target);
        if(k == 0){
            return searchInArray(nums,target, 0, nums.length-1);
        }
        if(nums[k] == target){
            return k; 
        }else if (nums[k] <= target && target <= nums[nums.length-1]){
            return searchInArray(nums, target, k+1, nums.length-1);
        }else {
            return searchInArray(nums, target, 0, k-1);
        }
    }

    public int findPivot(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return mid;
            } else if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    public int searchInArray(int[] nums, int target, int l , int r){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            } else if(target < nums[mid]){
                 r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}

