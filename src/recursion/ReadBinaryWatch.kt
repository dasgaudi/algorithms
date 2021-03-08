
fun main() = println("results of the read binary watch: ${readBinaryWatch(2)}")

fun readBinaryWatch(num: Int): List<String>? {
    val res: MutableList<String> = ArrayList()
    val hours = intArrayOf(8, 4, 2, 1)
    val minutes = intArrayOf(32, 16, 8, 4, 2, 1)
    for (i in 0..num) {
        val listOfHours = generateDigit(hours, i)
        val listOfMinutes = generateDigit(minutes, num - i)
        for (hour in listOfHours) {
            if (hour >= 12) continue
            for (minute in listOfMinutes) {
                if (minute >= 60) continue
                res.add(hour.toString() + ":" + if (minute < 10) "0$minute" else minute)
            }
        }
    }
    return res
}

private fun generateDigit(arr: IntArray, count: Int): List<Int> {
    val res: MutableList<Int> = ArrayList()
    generateDigit(arr, count, 0, 0, res)
    return res
}

private fun generateDigit(arr: IntArray, count: Int, pos: Int, sum: Int, res: MutableList<Int>) {
    if (count == 0) {
        res.add(sum)
        return
    }
    for (i in pos until arr.size) {
        generateDigit(arr, count - 1, i + 1, sum + arr[i], res)
    }
}