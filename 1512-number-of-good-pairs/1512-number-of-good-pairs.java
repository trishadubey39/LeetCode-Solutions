class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0, cnt[] = new int[101];
        for (int i =0;i<nums.length;i++) {
            ans += cnt[nums[i]]++;
        }
        return ans;
    }
}