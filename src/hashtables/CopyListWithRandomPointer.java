package hashtables;

import java.util.HashMap;
import java.util.Map;

class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // the idea here is to save the relationships between 2 nodes in the hashtable
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node node=head;

        while(node!=null) {
            Node n=new Node(node.val);
            map.put(node,n);
            node=node.next;
        }
        for(Map.Entry<Node, Node> entry: map.entrySet()) {
            Node main=entry.getKey();
            Node copy=entry.getValue();
            copy.next = main.next != null ? map.get(main.next) : null;
            copy.random = main.random != null ? map.get(main.random) : null;
        }
        return map.get(head);
    }
}
