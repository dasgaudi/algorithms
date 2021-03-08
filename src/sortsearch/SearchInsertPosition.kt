fun searchInsert(nums: IntArray, target: Int): Int {
    // edge cases
    if (target < nums[0]) return 0
    if (target > nums[nums.size - 1]) return nums.size

    // then binary search
    var low = 0
    var high = nums.size - 1
    var mid: Int
    while (low <= high) {
        mid = (low+high)/2
        when {
            nums[mid] == target -> {
                return mid
            }
            nums[mid] < target -> {
                low = mid + 1
            }
            else -> {
                high = mid - 1
            }
        }
    }
    return low
}

