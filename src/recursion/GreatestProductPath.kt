/*
Given an 2D array, find the path that generates the greatest product
 */

fun main() {
    println("the result of the greatest product path: ${greatestProductPath(arrayOf(arrayOf(1,2), arrayOf(3,4)) )}")
}

fun greatestProductPath(arr: Array<Array<Int>>): Path {
    val result = Path()
    greatestProductPath(arr, 0, 0, 1, Prod(`val` = 1), Path(), result)
    return result
}

fun greatestProductPath(arr: Array<Array<Int>>, i: Int, j:Int, current: Int, max: Prod, path: Path, result: Path) {
    if (i >= arr.size || j >= arr.size) return

    path.paths?.add(Move(i,j))

    if (i == arr.size-1 && j == arr.size-1) {
        if (current * arr[i][j] > max.`val`) {
            max.`val` = current * arr[i][j]
            result.paths = path.paths?.toMutableList()
        }
    }

    greatestProductPath(arr, i+1, j, current * arr[i][j], max, path, result)
    greatestProductPath(arr, i, j+1, current * arr[i][j], max, path, result)
}

data class Prod(
    var `val`: Int
)

data class Path(
    var paths: MutableList<Move> ?= mutableListOf()
)

data class Move(
    val i: Int,
    val j: Int
)