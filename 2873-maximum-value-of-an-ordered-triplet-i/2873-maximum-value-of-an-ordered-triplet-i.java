class Solution {
    public long maximumTripletValue(int[] nums) {
        long max_value = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long current_value = (long )(nums[i] - nums[j]) * nums[k]; 

                    max_value = Math.max(max_value, current_value); 
                }
            }
        }

        return Math.max(max_value, 0L);
    }
}