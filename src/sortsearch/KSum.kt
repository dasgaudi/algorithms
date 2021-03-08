import java.util.*

fun main() =
    println("the results of the sum: ${`kSum`(arrayOf(-2,0,1,1,2),0)}")



fun `kSum`(arr: Array<Int>, target: Int): List<List<Int>> {
    Arrays.sort(arr)
    return `kSum`(arr, 0,3,target)
}

fun `kSum`(arr: Array<Int>, start: Int, k: Int, target: Int): MutableList<MutableList<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    if (k == 2) {
        //two pointers from left and right
        var left = start
        var right = arr.size - 1
        while (left < right) {
            val sum = arr[left] + arr[right]
            when {
                sum == target -> {
                    results.add(mutableListOf(arr[left], arr[right]))
                    while (left < right && arr[left] == arr[left + 1]) left++
                    while (left < right && arr[right] == arr[right - 1]) right--
                    left++
                    right--
                }
                sum < target -> {
                    left++
                }
                else -> {
                    right--
                }
            }
        }
    } else {
        for (i in start until arr.size - (k - 1)) {
            if (i > start && arr[i] == arr[i - 1]) continue
            val temp = `kSum`(arr, i + 1, k - 1, target - arr[i])
            for (t in temp) {
                t.add(0, arr[i])
            }
            results.addAll(temp)
        }
    }
    return results
}