class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0)
            return false;
        
        HashSet<Integer> hset = new HashSet<Integer>();
        
        for(int idx: nums){
            
            if(!hset.add(idx)){
                return true;
            }
        }
        
        return false;
    }
}