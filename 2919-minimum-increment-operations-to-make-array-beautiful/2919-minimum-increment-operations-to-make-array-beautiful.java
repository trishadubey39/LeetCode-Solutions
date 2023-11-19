class Solution {
    public long memo(int[] nums,int curr,int count,int k,Long[][] dp)
    {
        if(curr == nums.length) return 0;
        if(dp[curr][count]!=null) return dp[curr][count];
        long min = Long.MAX_VALUE;
        //take (choice)
        min = Math.min(min,((nums[curr] < k)?(k-nums[curr]):0) +memo(nums,curr+1,2,k,dp));
        //dont take
        if(count > 0) min = Math.min(min,memo(nums,curr+1,count-1,k,dp));
        return dp[curr][count] = min;
    }
    public long minIncrementOperations(int[] nums, int k) {
        return memo(nums,0,2,k,new Long[nums.length][3]);
    }
}