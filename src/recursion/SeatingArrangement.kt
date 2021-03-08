/**
 * A teacher is trying to arrange a seating chart in their classroom.
 * They have N students who will sit in a line.
 * They also have a list of pairs of students who have to sit next to each other.
 * Write a function to find all of the possible seating arrangements
 */

fun main() {
    println("seating arrangements: ${seatingArrangements(4, mutableMapOf(1 to 2, 2 to 1))}")
}

fun seatingArrangements(N: Int, pairs: Map<Int, Int>): List<List<Int>> {
    val remaining: MutableSet<Int> = mutableSetOf()
    for (i in 1..N) remaining.add(i)

    val results: MutableList<MutableList<Int>> = mutableListOf()
    seatingArrangements(remaining, pairs, mutableListOf(), results)
    return results
}

fun seatingArrangements(remaining: MutableSet<Int>, pairs: Map<Int, Int>, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (remaining.isEmpty()) {
        results.add(path.toMutableList())
        return
    }

    for (i in remaining.toTypedArray()) {
        println("remainings $remaining")
        remaining.remove(i)
        path.add(i)
        val j = pairs.get(i)
        if (j != null) {
            remaining.remove(j)
            path.add(j)
        }

        seatingArrangements(remaining, pairs, path, results)

        remaining.add(i)
        path.removeAt(path.size - 1)
        if (j != null) {
            remaining.add(j)
            path.removeAt(path.size - 1)
        }
    }
}