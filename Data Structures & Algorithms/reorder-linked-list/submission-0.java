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
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode middle = reverseList(slow.next);
        ListNode temp1 = head, temp2 = middle;
        slow.next = null;
        while(temp1 != null && temp2 != null){
            ListNode next1 = temp1.next; // store the next nodes of both temp1 and temp2
            ListNode next2 = temp2.next;
            temp1.next  = temp2; // assign temp2 to next of temp
            temp2.next = next1;  // assign next1 to temp2.next

            temp1 = next1;
            temp2 = next2;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next, temp=head;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
