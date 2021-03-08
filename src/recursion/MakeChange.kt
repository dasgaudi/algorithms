/*
given N and coins,
find the minimum number of coins to make that amount of change.
 */

fun main() {
    val N = 12
    println("the result of make changes: ${makeChange(N, listOf(1,6,10))}")
    println("the result of make changes: ${makeChange_1(N, listOf(1,6,10), IntArray(N+1))}")
    println("the result of make changes: ${makeChange_2(N, listOf(1,6,10))}")
}

// brute force
// the minimum number of coins for the change (n - coin)
fun makeChange(N: Int, coins: List<Int>): Int {
    if (N == 0) return 0
    var min = Int.MAX_VALUE

    for (coin in coins) {
        if (N - coin >= 0) {
            val currentMin = makeChange(N - coin, coins)
            min = Math.min(min, currentMin)
        }
    }
    return min + 1
}

// top-down approach
fun makeChange_1(N: Int, coins: List<Int>, dp: IntArray): Int {
    if (dp[N] == 0) {
        if (N == 0) return 0
        var min = Int.MAX_VALUE

        for (coin in coins) {
            if (N - coin >= 0) {
                val currentMin = makeChange_1(N - coin, coins, dp)
                min = Math.min(min, currentMin)
            }
        }
        dp[N] = min + 1
    }

    return dp[N]
}

// bottom-up
fun makeChange_2(N: Int, coins: List<Int>): Int {
    val dp = IntArray(N+1)

    for (i in 1..N) {
        var min = Int.MAX_VALUE
        for (coin in coins) {
            if (N-coin >= 0) {
                min = Math.min(min, dp[N - coin])
            }
        }
        dp[i] = min + 1
    }

    return dp[N]
}