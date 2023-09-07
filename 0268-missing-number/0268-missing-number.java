class Solution {
    public int missingNumber(int[] nums) {
       int sum = ((nums.length)*((nums.length)+1))/2;
        int out_sum = 0;
        int result =0;
        for(int i=0;i<nums.length;i++){
            out_sum += nums[i];
        }
        
       result= sum-out_sum; 
        return result;
    }
}