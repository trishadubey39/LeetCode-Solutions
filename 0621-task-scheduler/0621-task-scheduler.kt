class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        tasks.forEach { task ->
            freq[task - 'A']++
        }
        freq.sort()
        var chunk = freq[25] - 1
        var idle = chunk * n

        for (i in 24 downTo 0) {
            idle -= minOf(chunk, freq[i])
        }

        return if (idle < 0) tasks.size else tasks.size + idle
    }
}