/**
 * given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 */

// brute force
fun kthSmallestBruteForce(root: TreeNode?, k: Int): Int {
    if (root == null) return 0

    val left = countNodes(root.left) + 1
    val right = countNodes(root.right)

    return when {
        k == left -> {
            root.`val`
        }
        k <= left -> {
            kthSmallestBruteForce(root.left, k)
        }
        else -> {
            kthSmallestBruteForce(root.right, k-left)
        }
    }
}

// slight better solution
fun kthSmallest(root: TreeNode?, k: Int): Int {
    if (root == null) return 0

    val count = countNodes(root.left)
    if (k <= count) {
        return kthSmallest(root.left, k)
    } else if (k > count + 1) {
        return kthSmallest(root.right, k - 1 - count) // 1 is counted as current node
    }
    return root.`val`
}


fun countNodes(n: TreeNode?): Int {
    return if (n == null) 0 else 1 + countNodes(n.left) + countNodes(n.right)
}


fun kthSmallestRecursion(root: Node?, k: Int): Int {
    val result = Wrapper(k)
    kthSmallestRecursion(root, result)
    return result.number
}

fun kthSmallestRecursion(n: Node?, result: Wrapper) {
    if (n != null) {
        if (n.left != null) kthSmallestRecursion(n.left, result)
    }
    result.count--
    if (result.count == 0) {
        if (n != null) {
            result.number = n.`value`
        }
        return
    }
    if (n != null) {
        if (n.right != null) kthSmallestRecursion(n.right, result)
    }
}

data class Wrapper(
    var count: Int = 0,
    var number: Int = 0
)

fun main() {
    val root = Node(left = Node(value = 3, left=Node(value = 2, left= Node(value = 1)), right=Node(value = 4)), right = Node(value = 6), value = 5)
    println("all possible BST: ${kthSmallestRecursion(root= root, k = 3)}")
}