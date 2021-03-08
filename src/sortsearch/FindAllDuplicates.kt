/*
given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
find all the elements that appear twice in this array.

do it without extra space and in O(n) runtime?
*/

fun main() {
    println("the results of the find duplicates: ${findDuplicates(intArrayOf(1,2,3,4,1,2,5,6))}")
    println("the results of the find duplicates: ${findDuplicates(arrayOf(1,2,3,4,1,2,5,6))}")

}

// **value of element can also be the index
fun findDuplicates(nums: IntArray): List<Int> {
    val results: MutableList<Int> = mutableListOf()
    for (num in nums) {
        val i = Math.abs(num) - 1
        if (nums[i] < 0) results.add(Math.abs(num))
        nums[i] = - nums[i]
    }
    return results
}

// brute force solution
// time complexity O(n) space complexity O(n)
fun findDuplicates(arr: Array<Int>): List<Int> {
    val results: MutableList<Int> = mutableListOf()
    val map: MutableMap<Int, Int> = mutableMapOf()

    for (element in arr) {
        if (map.containsKey(element)) {
            map[element] = map[element]!! +1
        } else {
            map[element] = 1
        }
    }
    // filter
    for (key in map.keys) {
        if (map[key] == 2) {
            results.add(key)
        }
    }
    return results
}