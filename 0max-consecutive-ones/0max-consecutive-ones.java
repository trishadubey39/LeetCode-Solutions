class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prevCount = 0, count =0;
        for(int i : nums){
            if(i == 1){
                count ++;
            }else{
                prevCount = prevCount<count ? count : prevCount;
                count = 0;
            }
        
        }
        
        return prevCount<count ? count : prevCount;
    }
}