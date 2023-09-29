class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isInc = true; 
        boolean isDec = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                isInc = false;

            else if (nums[i] > nums[i - 1])
                isDec = false;

            if (!isInc && !isDec)
                break;
        }

        return isInc || isDec;
    
    }
}