class Solution {
    public int firstMissingPositive(int[] nums) {
        int i =0;
        while(i<nums.length){
            if(nums[i]<=nums.length && nums[i]>0 && i != nums[i]-1){
                if(nums[i] == nums[nums[i]-1]){
                    i++; //duplicate nums
                }else{
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
                }

            }else{ // ignore negative nums and nums at proper indices
                i++;
            }
        }
        for(int j=0;j<nums.length ; j++){
            if(j != nums[j]-1){
                return j+1;
            }
        }
        return nums.length+1;
    }
}