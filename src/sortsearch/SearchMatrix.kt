/*
write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
- integers in each row are sorted from left to right.
- the first integer of each row is greater than the last integer of the previous row.
 */

fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
    // assumption: m, n could be different values

    // go through each row
    // check the target value is in range
    // then search
    // otherwise, go to the next row
    for (row in matrix) {
        if (isTargetInRange(row, target)) {
            return isTargetExisted(row, target)
        }
    }
    // at the end of loop, return false
    return false
}

fun isTargetInRange(arr: IntArray, target: Int) = arr[0] <= target && arr[arr.size-1] >= target
fun isTargetExisted(arr: IntArray, target: Int): Boolean {
    if (target < arr[0]) return false
    if (target > arr[arr.size-1]) return false

    // then binary search
    var low = 0
    var high = arr.size - 1
    var mid: Int
    while (low <= high) {
        mid = (low+high)/2
        when {
            arr[mid] == target -> {
                return true
            }
            arr[mid] < target -> {
                low = mid + 1
            }
            else -> {
                high = mid - 1
            }
        }
    }
    return false
}

// when the input is larger, this solution becomes way slower
fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return false
    }
    var row = 0
    var col: Int = matrix[0].size- 1
    while (row < matrix.size && col >= 0) {
        when {
            matrix[row][col] == target -> {
                return true
            }
            matrix[row][col] < target -> {
                row++
            }
            else -> {
                col--
            }
        }
    }
    return false
}