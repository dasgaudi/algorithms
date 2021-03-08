/*
Generate all possible combinations of the given array with the given length
*/

fun main() {
    println("the combinations: ${combinationsOfLength_1(arrayOf(1,2,3,4), 2)}")
    println("the combinations: ${combinationOfLength_2(arrayOf(1,2,3,4), 2)}")
}

// passed variable
fun combinationsOfLength_1(arr: Array<Int>, targetLength: Int): List<List<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    combinationsOfLength_1(arr, 0, mutableListOf(), results, targetLength, 0)
    return results
}

fun combinationsOfLength_1(arr: Array<Int>, i: Int, path: MutableList<Int>, results: MutableList<MutableList<Int>>, targetLength: Int, currentLength: Int) {
    if (currentLength > targetLength || (i == arr.size && currentLength != targetLength)) return

    if (i == arr.size) {
        results.add(path.toMutableList())
        return
    }
    val pathWithCurrent = path.toMutableList()
    pathWithCurrent.add(0,arr[i])

    // include the current element of the array
    combinationsOfLength_1(arr, i+1, path, results, targetLength, currentLength+1)
    // exclude the current element of the array
    combinationsOfLength_1(arr, i+1, pathWithCurrent, results, targetLength, currentLength)
}

fun combinationOfLength_2(arr: Array<Int>, targetLength: Int): List<List<Int>> {
    return combinationOfLength_2(arr, 0, targetLength, 0)
}

fun combinationOfLength_2(arr: Array<Int>, i: Int, targetLength: Int, currentLength: Int): MutableList<MutableList<Int>> {
    if (currentLength > targetLength || (i == arr.size && currentLength != targetLength)) return mutableListOf()

    if (i == arr.size) {
        val toReturn: MutableList<MutableList<Int>> = mutableListOf()
        toReturn.add(mutableListOf())
        return toReturn
    }
    val include = combinationOfLength_2(arr, i+1, targetLength, currentLength + 1)
    val exclude = combinationOfLength_2(arr, i+1, targetLength, currentLength)

    val toReturn: MutableList<MutableList<Int>> = mutableListOf()

    for (result in include) {
        result.add(0, arr[i])
        toReturn.add(result)
    }
    toReturn.addAll(exclude)
    return toReturn
}


