import java.util.*

/*
Find the path in a tree from the root to a node
 */

fun main() {
    val root = Node(left = Node(left = Node(value = 4), right= Node(value = 5),value = 2), right = Node(value=3), value = 1)

    println("result: ${pathToNode(
            root, 5
    )}")
}
fun pathToNode(root: Node?, `val`: Int): MutableList<Int>? {
    if (root == null) return null
    if (root.value == `val`) {
        val toReturn: MutableList<Int> = LinkedList()
        toReturn.add(root.value)
        return toReturn
    }
    val left = pathToNode(root.left, `val`)
    if (left != null) {
        left.add(0, root.value)
        return left
    }
    val right = pathToNode(root.right, `val`)
    if (right != null) {
        right.add(0, root.value)
        return right
    }
    return null
}