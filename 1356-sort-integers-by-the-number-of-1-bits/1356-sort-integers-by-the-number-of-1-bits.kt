class Solution {
        fun sortByBits(arr: IntArray): IntArray {
            val n = arr.size
            val res = IntArray(n)
            for (i in 0 until n) {
                res[i] = countBit(arr[i]) * 10001 + arr[i]
            }
            Arrays.sort(res)
            for (i in 0 until n) {
                res[i] %= 10001
            }
            return res
        }

        private fun countBit(n: Int): Int {
            var n = n
            var res = 0
            while (n != 0) {
                res += n and 1
                n = n shr 1
            }
            return res
        }
}