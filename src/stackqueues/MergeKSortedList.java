import java.util.PriorityQueue;

/**
 * #23. Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
class MergeKSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // the idea here is to keep only k nodes in queue
    // e.g) [[1,4,5], [1,3,4], [2,6]]
    // q = [1,1,2]
    // q = [1,2,3]
    // q = [3,4,6]
    // q = [4,4,6]
    // q = [4,5,6]
    // ....
    static ListNode mergeKList(ListNode[] list) {
        if (list == null || list.length ==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(list.length, (a,b) -> a.val - b.val);

        for (ListNode n: list) pq.offer(n);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) pq.offer(tail.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode n3 = new ListNode(2, new ListNode(6));
        ListNode head = mergeKList(new ListNode[] {n1,n2,n3});
    }
}
