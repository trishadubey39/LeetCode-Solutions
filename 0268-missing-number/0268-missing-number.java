class Solution {
    public int missingNumber(int[] nums) {
        int num = 0;
       for(int i=0;i<nums.length;i++){
           num = num^i+1;
           num = num^nums[i];
       } 
       return num;
    }
}