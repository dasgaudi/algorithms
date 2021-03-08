package lists;

class MergeSort {
    // required data structure
    static class ListNode {
        int val;
        ListNode next; 
    
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
        
    static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // ** remove the pointer for the next node
        prev.next = null;
        
        ListNode l1 = sort(head);
        ListNode l2 = sort(slow);
        return merge(l1, l2);
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return l.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = sort(head);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

