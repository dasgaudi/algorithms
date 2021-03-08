import java.util.*

/*
print a binary tree in an m*n 2D string array following these rules:
the row number m should be equal to the height of the given binary tree.
the column number n should always be an odd number.
the root node's value (in string format) should be put in the exactly middle of the first row it can be put.
the column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part).
you should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part.
the left-bottom part and the right-bottom part should have the same size.
even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree.
however, if two subtrees are none, then you don't need to leave space for both of them.
each unused space should contain an empty string "".
print the subtrees following the same rules.
*/

fun main() {
    val root = TreeNode(1, TreeNode(2, null, TreeNode(4)), TreeNode(3))
    println("the results of printTree: ${printTree(root)}")
}

fun printTree(root: TreeNode?): List<MutableList<String>>? {
    val res: MutableList<MutableList<String>> = LinkedList()
    val height = root?.let { getHeight(it) } ?: 1
    val columns = (Math.pow(2.0, height.toDouble()) - 1).toInt()
    val row: MutableList<String> = ArrayList()
    for (i in 0 until columns) row.add("\"\"")
    for (i in 0 until height) res.add(ArrayList(row))
    populateRes(root, res, 0, height, 0, columns - 1)
    return res
}

fun populateRes(root: TreeNode?, res: List<MutableList<String>>, row: Int, totalRows: Int, i: Int, j: Int) {
    if (row == totalRows || root == null) return
    res[row][(i + j) / 2] = root.`val`.toString()
    populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1)
    populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j)
}

fun getHeight(root: TreeNode?): Int {
    return if (root == null) 0 else 1 + Math.max(getHeight(root.left), getHeight(root.right))
}