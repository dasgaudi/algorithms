/**
 * given a BST, determine all possible ways that could have generated BST
 */

data class Node(
        val left: Node? = null,
        val right: Node? = null,
        var value: Int
)


fun allBST(root: Node): MutableList<MutableList<Int>> {
    val results: MutableList<MutableList<Int>> = mutableListOf()
    allBST(mutableSetOf(root), mutableListOf(), results)
    return results
}

fun allBST(available: MutableSet<Node>, path: MutableList<Int>, results: MutableList<MutableList<Int>>) {
    if (available.isEmpty()) {
        results.add(path.toMutableList())
        return
    }

    for (node in available.toTypedArray()) {
        available.remove(node)
        if (node.left != null) available.add(node.left)
        if (node.right != null) available.add(node.right)
        path.add(node.value)

        allBST(available, path, results)

        available.add(node)
        if (node.left != null) available.remove(node.left)
        if (node.right != null) available.remove(node.right)
        path.removeAt(path.size - 1)
    }
}

fun main() {
    val root = Node(left = Node(value = 2), right = Node(value = 3), value = 1)
    println("all possible BST: ${allBST(root)}")
}