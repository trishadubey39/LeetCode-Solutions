class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int maxSum = nums[0];
        Deque<Integer> maxSumQueue = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] += !maxSumQueue.isEmpty() ? maxSumQueue.peek() : 0;
            maxSum = Math.max(maxSum, nums[i]);
            
            while (!maxSumQueue.isEmpty() && nums[i] > maxSumQueue.peekLast()) {
                maxSumQueue.pollLast();
            }
            
            if (nums[i] > 0) {
                maxSumQueue.offer(nums[i]);
            }
            
            if (i >= k && !maxSumQueue.isEmpty() && maxSumQueue.peek() == nums[i - k]) {
                maxSumQueue.poll();
            }
        }
        
        return maxSum;
    }
}