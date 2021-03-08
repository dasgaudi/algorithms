
import java.util.*;

class MinStack {

    // the idea here is to have a node that stores val, min value, and the next for referring the next node
    class Node {
        int val;
        int min;
        Node next;
        
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    } 
    
    Stack<Node> stack;
    Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<Node>();
        this.head = null;
    }   
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x,x,null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}