class Solution {
    public int missingNumber(int[] nums) {
        int result =0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                result = i;
                break;
            }
        }
        
    
         if(result ==0 && nums[0]==0) result = nums[nums.length-1]+1;
        return result;
    }
}