/*
given a binary tree, you need to compute the length of the diameter of the tree.
the diameter of a binary tree is the length of the longest path between any two nodes in a tree.
this path may or may not pass through the root.

given a binary tree

          1
         / \
        2   3
       / \
      4   5
 */

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val dia = depth(root.left) + depth(root.right)
    val ldia = diameterOfBinaryTree(root.left)
    val rdia = diameterOfBinaryTree(root.right)
    return Math.max(dia, Math.max(ldia, rdia))
}

fun depth(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else 1 + Math.max(depth(root.left), depth(root.right))
}

