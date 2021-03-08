fun main() {
    val results = permutation(mutableSetOf(1,2,3))
    println("results of permutation $results")
}

fun permutation(items: MutableSet<Int>): List<List<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    permutation(items, mutableListOf(), results)
    return results
}

fun permutation(items: MutableSet<Int>, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (items.isEmpty()) {
        results.add(path.toMutableList())
        return
    }

    for (i in items.toTypedArray()) {
        items.remove(i)
        path.add(i)
        permutation(items, path, results)
        items.add(i)
        path.removeAt(path.size-1)
    }
}