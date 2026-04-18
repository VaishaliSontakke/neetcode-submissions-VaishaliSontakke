/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // a  b     c   d
    //     a1  b1  c1  d1 
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node temp = head;
        Node next = null;
        while(temp != null){
            // temp -> copyNode -> temp.next
            next = temp.next;
            temp.next = new Node(temp.val);
            temp = temp.next;
            temp.next = next;
            temp = next;
        }
        temp = head;

        while(temp != null && temp.next != null){
            // make random of copy node point to correct random.
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // remove the interlaced copy pointers
        temp = head;
        Node result = temp.next;
        next = null;
        // re-arrange nodes.
        while(temp != null && temp.next != null){
            next = temp.next;     
            temp.next = temp.next.next;
            temp = next;
        }
        return result; 
    }
}
