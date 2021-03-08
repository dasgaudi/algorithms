fun main() {
    println("permutation of length: ${permutationOfLength(mutableSetOf(1,2,3,4), 2)}")
}

fun permutationOfLength(items: MutableSet<Int>, length: Int): List<List<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    permutationOfLength(items, length, mutableListOf(), results)
    return results
}

fun permutationOfLength(items: MutableSet<Int>, length: Int, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (length == 0) {
        results.add(path.toMutableList())
        return
    }

    for (i in items.toTypedArray()) {
        path.add(i)
        items.remove(i)
        permutationOfLength(items, length-1, path, results)
        path.removeAt(path.size-1)
        items.add(i)
    }
}