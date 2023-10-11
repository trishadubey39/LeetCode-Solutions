class Solution {
    fun fullBloomFlowers(flowers: Array<IntArray>, people: IntArray): IntArray {
        val n = flowers.size
        val start = IntArray(n)
        val end = IntArray(n)
        for (i in 0 until n) {
            start[i] = flowers[i][0]
            end[i] = flowers[i][1]
        }
        Arrays.sort(start)
        Arrays.sort(end)
        val res = IntArray(people.size)
        for (i in people.indices) {
            val t = people[i]
            val started = binarySearchUpperBound(start, t)
            val ended = binarySearchLowerBound(end, t)
            res[i] = started - ended
        }
        return res
    }

    private fun binarySearchUpperBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun binarySearchLowerBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
     
    }
}