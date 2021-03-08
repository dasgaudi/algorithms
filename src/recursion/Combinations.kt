import java.lang.management.MemoryUsage

/*
Generate all possible combinations of the given array
 */

/*
notes: branching factor: 2
       (either include or exclude the current element)
 */
fun main() {
    println("the combinations: ${combinations_1(arrayOf(1,2,3,4))}")
    println("the combinations: ${combinations_2(arrayOf(1,2,3,4))}")

}

// passed variable
fun combinations_1(arr: Array<Int>): List<List<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    combinations_1(arr, 0, mutableListOf(), results)
    return results
}

fun combinations_1(arr: Array<Int>, i: Int, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (i == arr.size) {
        results.add(path.toMutableList())
        return
    }
    val pathWithCurrent = path.toMutableList()
    pathWithCurrent.add(0, arr[i])

    // include the current element of the array
    combinations_1(arr, i+1, path, results)
    // exclude the current element of the array
    combinations_1(arr, i+1, pathWithCurrent, results)
}

// built up
fun combinations_2(arr: Array<Int>): List<List<Int>> {
    return combinations_2(arr, 0)
}

fun combinations_2(arr: Array<Int>, i: Int): List<List<Int>> {
    if (i == arr.size) {
        val toReturn: MutableList<MutableList<Int>> = mutableListOf()
        toReturn.add(mutableListOf())
        return toReturn
    }

    val toReturn: MutableList<MutableList<Int>> = mutableListOf()
    for (result in combinations_2(arr, i+1)) {
        val exclude = result.toMutableList()
        toReturn.add(exclude)
        val include = result.toMutableList()
        include.add(0, arr[i])
        toReturn.add(include)
    }
    return toReturn
}

