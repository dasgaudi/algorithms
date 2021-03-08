/**
given an array where elements are sorted in ascending order, convert it to a height balanced BST.
for this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

data class TreeNode(
    val `val`: Int,
    var left: TreeNode ?= null,
    var right: TreeNode ?= null
)
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null
    // brute force
    // find a root node
    // left subtree should be less than a root node
    // right subtree should be greater than a root node
    // *using index
    return bst(nums, 0, nums.size - 1)

}

fun bst(nums: IntArray, low: Int, high: Int): TreeNode? {
    if (low > high) {
        return null
    }
    val mid = (low+high)/2
    val node = TreeNode(nums[mid])
    node.left = bst(nums, low, mid - 1)
    node.right = bst(nums, mid + 1, high)

    return node
}




