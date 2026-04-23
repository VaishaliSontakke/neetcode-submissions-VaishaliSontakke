class Solution {
    public boolean canJump(int[] nums) {
        // Start goal from end. start making goal lesser if i+nums[i] == goal.
        // update goal
        // 12010
        // 01234
        // goal 4
        // goal 3 (as 3+ 1 == 4)
        // goal 2 (as 2+ 1 == 3)
        // goal 1 (as 1+1 = 2)
        // goal 0 as (0+1 = 1 )
        int goal = nums.length-1;
        for(int i = nums.length-1; i>=0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        if(goal == 0){
            return true;
        }
        return false;
    }
}
