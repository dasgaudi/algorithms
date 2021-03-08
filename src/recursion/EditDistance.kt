import java.lang.Integer.min

fun main() {
    val editDistanceRecursion = editDistance_1("abc", "abd", 3,3)
    println("minimum number of movements $editDistanceRecursion")

    val editDistanceDp = editDistance_2("abc", "abd", 3,3)
    println("minimum number of movements $editDistanceDp")
}

fun editDistance_1(s1: String, s2: String, m: Int, n: Int): Int {
    if (m == 0) return n
    if (n == 0) return m

    if (s1[m-1] == s2[n-1]) {
        return editDistance_1(s1, s2, m-1, n-1)
    }
    return 1 + min(editDistance_1(s1, s2, m, n-1), min(editDistance_1(s1, s2, m-1, n), editDistance_1(s1, s2, m-1, n-1)))
}

fun editDistance_2(s1: String, s2: String, m: Int, n: Int): Int {
    val results = Array(n+1) { IntArray(m+1)}

    for (i in 0..m) {
        for (j in 0..n) {
            when {
                i == 0 -> results[i][j] = j
                j == 0 -> results[i][j] = i
                s1[i-1] == s2[j-1] -> results[i][j] = results[i-1][j-1]
                else -> results[i][j] = 1 + min(results[i][j-1], min(results[i-1][j], results[i-1][j-1]))
            }
        }
    }
    return results[m][n]
}

