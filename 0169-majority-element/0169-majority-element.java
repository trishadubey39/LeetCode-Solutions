class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            }
            else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;
    }
}