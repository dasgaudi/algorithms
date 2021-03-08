import java.util.*

/*
given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
find all unique triplets in the array which gives the sum of zero.
 */

fun main() =
    println("the results of the sum: ${`3Sum`(arrayOf(-2,0,1,1,2))}")

/*
try to use 2 pointers
 */
fun `3Sum`(arr: Array<Int>): List<List<Int>> {
    Arrays.sort(arr)
    val results: MutableList<List<Int>> = mutableListOf()

    for (i in 0 until arr.size-2) {
        // no more ways to make them summed to zero 
        if (arr[i] > 0) break
        // *skip the duplicates
        if (i > 0 && arr[i] == arr[i - 1]) continue
        var low = i + 1
        var high = arr.size - 1
        val target = -arr[i]
        while (low < high) {
            when {
                arr[low] + arr[high] == target -> {
                    results.add(listOf(arr[i], arr[low], arr[high]))
                    while (low < high && arr[low] == arr[low + 1]) low ++
                    while (low < high && arr[high] == arr[high - 1]) high --
                    low ++
                    high --
                }
                arr[low] + arr[high] > target -> {
                    high --
                }
                else -> {
                    low ++
                }
            }
        }
    }

    return results
}

