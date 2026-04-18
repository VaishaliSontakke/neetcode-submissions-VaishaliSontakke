/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h1 = new ListNode(0), prev=null;
        h1.next = head;

        ListNode temp=head;
        //move a pointer from start of list it to a distance n from start.
        for(int i=0; i< n && temp!= null; i++){
            temp = temp.next;
        }
        // curr start at dummy, as we reach prev node to the node to be deleted.
        ListNode curr = h1;
        // move both pointer till temp reaches null.
        while(temp != null){
            temp = temp.next;
            curr = curr.next;
        }
        // curr is prev element hence delete curr.next
        curr.next = curr.next.next;

        return h1.next;
    }
}
