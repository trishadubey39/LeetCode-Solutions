/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *     fun get(index: Int): Int {}
 *     fun length(): Int {}
 * }
 */

class Solution {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
                val length: Int = mountainArr.length()
        val peakIndex = findPeakIndex(1, length - 2, mountainArr)
        val increasingIndex = binarySearch(0, peakIndex, target, mountainArr, false)
        if (mountainArr.get(increasingIndex) === target) return increasingIndex
        val decreasingIndex = binarySearch(peakIndex + 1, length - 1, target, mountainArr, true)
        return if (mountainArr.get(decreasingIndex) === target) decreasingIndex else -1
    }

    private fun findPeakIndex(low: Int, high: Int, mountainArr: MountainArray): Int {
        var low = low
        var high = high
        while (low != high) {
            val mid = low + (high - low) / 2
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }

    private fun binarySearch(
        low: Int,
        high: Int,
        target: Int,
        mountainArr: MountainArray,
        reversed: Boolean
    ): Int {
        var low = low
        var high = high
        while (low != high) {
            val mid = low + (high - low) / 2
            if (reversed) {
                if (mountainArr.get(mid) > target) low = mid + 1 else high = mid
            } else {
                if (mountainArr.get(mid) < target) low = mid + 1 else high = mid
            }
        }
        return low
    }
}