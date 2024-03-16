class Solution {
    public int findMaxLength(int[] nums) {
        int left = 0, right = 0, len = nums.length;
        for(int indx = 0; indx < len; indx++){
           if(nums[indx] == 0) 
            nums[indx]  = -1;
        }
        int prefSum = 0;
        Map<Integer, Integer> prefSumIndxMp = new HashMap<>();
        prefSumIndxMp.put(0, -1);
        int maxSubLen = 0;
        for(int indx = 0; indx < len; indx++){
            prefSum += nums[indx];
            if(prefSumIndxMp.containsKey(prefSum - 0)){
                maxSubLen = Math.max(maxSubLen, indx - prefSumIndxMp.get(prefSum - 0));
            }
            if(!prefSumIndxMp.containsKey(prefSum)) prefSumIndxMp.put(prefSum, indx);
        }
        return maxSubLen;
    }
}