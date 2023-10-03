class Solution {
    fun winnerOfGame(colors: String): Boolean {
        var alice_plays = 0
        var bob_plays = 0
        var count = 0
        for (i in 1 until colors.length) {
          if (colors[i] == colors[i - 1]) {
            count++
          } else {
            if (colors[i - 1] == 'A') {
              alice_plays += Math.max(0, count - 1)
            } else {
              bob_plays += Math.max(0, count - 1)
            }
            count = 0
          }
        }
        if (colors[colors.length - 1] == 'A') {
          alice_plays += Math.max(0, count - 1)
        } else {
          bob_plays += Math.max(0, count - 1)
        }
        return alice_plays > bob_plays
    }
}