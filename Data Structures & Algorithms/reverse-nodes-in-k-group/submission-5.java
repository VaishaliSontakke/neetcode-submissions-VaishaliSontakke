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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, start = null;
        int count = 0;
        ListNode res = new ListNode(-1), res1 = res;
        ListNode prev = null, prevTail = res;
        while(curr != null){
            
            if(count == 0){
                start = curr;
            }
            while(count < k-1 && curr != null){
                curr = curr.next;
                count++;
            }
            if(curr == null){
                break;
            }
            // here group is now formed (start - curr) curr.next
            ListNode next = curr.next;
            ListNode temp = start;
            while(temp != null && temp != next){
                ListNode n1 = temp.next;
                temp.next = prev;
                prev = temp;
                temp = n1;
            }
            // prev is now at end of group, 
            prevTail.next = prev;
            prevTail = start;
            curr = next;
            
            count = 0;
            prev = start= null;
            
        }
        prevTail.next = start;
        return res1.next;
    }

}
