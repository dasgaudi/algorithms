package lists;

class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }

    }

    // it works with small amount of input, but failed when a node becomes really big
    // brute force
    ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        StringBuilder temp1 = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        ListNode fake = new ListNode(-1);
        ListNode head = fake;
        
        while (l1 != null) {
            temp1.append(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            temp2.append(l2.val);
            l2 = l2.next;
        }   
        
        int temp = Integer.parseInt(temp1.reverse().toString())+Integer.parseInt(temp2.reverse().toString());
        String result = new StringBuilder().append(temp).toString();
        
        int i = result.length()-1;
        while (i >= 0) {
            head.next = new ListNode(Character.getNumericValue(result.charAt(i)));
            head = head.next;
            i--;
        }
        
            return fake.next;
    }
 
    // the idea here is to take care of the sum of 2 values from nodes
    // handle overflowing with '/' and '%'
    ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode current = fake;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum /= 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // handle when the both nodes end, but overflowing occurs
        if (sum / 10 == 1) {
            current.next = new ListNode(1);
        }

        return fake.next;
    }
}