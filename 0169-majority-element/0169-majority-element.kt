class Solution {
    fun majorityElement(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size/2]
    }
}