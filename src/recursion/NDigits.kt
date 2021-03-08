/*
Given two integers 'n' and 'sum', find count of all n digit numbers with sum of digits as 'sum'.
Leading 0's are not counted as digits. 1 <= n <= 100 and 1 <= sum <= 500
 */

fun main() {
    println("list of n digit ${nDigitsList(3,5)}")
    println("count of all n digits ${nDigitsCount_1(3,5)}")
    println("count of all n digits ${nDigitsCount_2(3,5)}")
}

fun nDigitsList(N: Int, target: Int): List<List<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    nDigitsList(N, target, 0, mutableListOf(), results)
    return results
}

fun nDigitsList(N: Int, target: Int, sum: Int, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (sum > target) return
    if (N == 0) {
        if (sum == target) {
            results.add(path.toMutableList())
        }
        return
    }

    for (i in 0..9) {
        if (sum == 0 && i == 0) continue
        path.add(i)
        nDigitsList(N-1, target, sum+i, path, results)
        path.removeAt(path.size - 1)
    }
}

fun nDigitsCount_1(N: Int, sum: Int): Int {
    var result = 0
    for (i in 1..9) {
        if (sum-i >= 0) {
            result += nDigitsCount_1(N-1, sum-i)
        }
    }
    return result
}

fun nDigitsCount_2(N: Int, sum: Int): Int {
    if (N == 0) return if (sum == 0) 1 else 0
    // when sum becomes 0, following digits will be automatically 0s
    if (sum == 0) return 1

    var result = 0
    for (i in 0..9) {
        result += nDigitsCount_2(N-1, sum-i)
    }
    return result
}



