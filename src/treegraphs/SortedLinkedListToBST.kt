import kotlin.math.pow
import kotlin.test.assertEquals

/*
given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
for this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

data class ListNode (
        val `val`: Int,
        var next: ListNode ?= null
)

fun main() {
    val head = ListNode(-10, ListNode(-3, ListNode(0, ListNode(5, ListNode(9)))))
    val result = sortedListToBST(head)
    val expectedResult = TreeNode(0, TreeNode(-3, TreeNode(-10), null), TreeNode(9, TreeNode(5), null))
}
fun sortedListToBST(head: ListNode?): TreeNode? {
    // edge cases
    // 1. head is null
    if (head == null) return null
    return toBST(head, null)
}

fun toBST(head: ListNode?, tail: ListNode?): TreeNode? {
    var slow = head
    var fast = head
    if (head === tail) return null
    while (fast !== tail && fast!!.next !== tail) {
        fast = fast!!.next!!.next
        slow = slow!!.next
    }

    val mid = TreeNode(slow!!.`val`)
    mid.left = toBST(head, slow)
    mid.right = toBST(slow.next, tail)
    return mid
}