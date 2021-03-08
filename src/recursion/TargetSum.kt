/*
Given an array of integers and a target, find all possible combinations of integers that sum up to the target
Values may be duplicated
 */

fun main() {
    println("results of target sum: ${targetSum(arrayOf(1,1,1,2,3,0), 3)}")
}

fun targetSum(arr: Array<Int>, target: Int): List<List<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    targetSum(arr, 0, target, mutableListOf(), results)
    return results
}

fun targetSum(arr: Array<Int>, i: Int, target: Int, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (target < 0) return
    if (target == 0) {
        if (!results.contains(path)) {
            // *only put unique combinations
            results.add(path.toMutableList())
        }
        return
    }
    if (i == arr.size) return

    // include the current arr[i]
    path.add(arr[i])
    targetSum(arr, i+1, target-arr[i], path, results)

    // exclude the current arr[i]
    path.removeAt(path.size-1)
    targetSum(arr, i+1, target, path, results)

}