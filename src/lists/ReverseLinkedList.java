package lists;

class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList_1(ListNode head) {
        /* recursive solution */
        return reverseList_1(head, null);
    }

    private ListNode reverseList_1(ListNode current, ListNode past) {
        if (current == null)
            return past;
        // save the next before chaning the next of current node.
        ListNode next = current.next;
        current.next = past;
        return reverseList_1(next, current);
    }

    public ListNode reverseList_2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
