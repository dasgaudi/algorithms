fun main() {
    println("permutation of duplicates ${permutationOfDuplicates(arrayOf(1,1,2))}")
}

fun permutationOfDuplicates(items: Array<Int>): List<List<Int>> {
    val itemsMap: MutableMap<Int, Int> = hashMapOf()
    for (i in items) {
        if (itemsMap.containsKey(i)) {
            itemsMap[i] = itemsMap[i]!! + 1
        } else {
            itemsMap[i] = 1
        }
    }
    val results: MutableList<MutableList<Int>> = mutableListOf()
    permutationOfDuplicates(itemsMap, mutableListOf(), results)
    return results
}

fun permutationOfDuplicates(itemsMap: MutableMap<Int, Int>, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (itemsMap.isEmpty()) {
        results.add(path.toMutableList())
        return
    }

    for(i in itemsMap.keys.toTypedArray()) {
        path.add(i)
        val currentValueForKey = itemsMap[i]
        if (currentValueForKey == 1) {
            itemsMap.remove(i)
        } else {
            itemsMap[i] = itemsMap[i]!! - 1
        }
        permutationOfDuplicates(itemsMap, path, results)
        itemsMap[i] = currentValueForKey!!
        path.removeAt(path.size - 1)
    }
}