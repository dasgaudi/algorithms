import java.lang.Math.max

/*
Given a tree, find the longest path of incrementing elements
element[i+1] = element[i] + 1
 */

fun main() {
    val root = Node(left = Node(left = Node(value = 4), right= Node(value = 5),value = 2), right = Node(value=3), value = 1)
    println("longest path length: ${longestIncreasingPath(root)}")
}

fun longestIncreasingPath(root: Node): Int {
    return longestIncreasingPath(root, 1, root)
}

fun longestIncreasingPath(root: Node?, pathLength: Int, parent:Node): Int {
    if (root == null) return pathLength
    if (root.value == parent.value + 1) {
        return max(
            longestIncreasingPath(root.left, pathLength+1, root),
            longestIncreasingPath(root.right, pathLength+1, root)
        )
    }

    return max(pathLength,
        max(
            longestIncreasingPath(root.left, pathLength, root),
            longestIncreasingPath(root.right, pathLength, root)
        )
    )
}

