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
        ListNode curr = head;
        int count = 0;
        ListNode start = null;
        ListNode res = new ListNode(-1), res1 = res;
        ListNode prev = null, prevTail = res;
        while(curr != null){
            // 0 1 2 << till 2 take curr forward.
            if(count == 0){
                start = curr;
            }
            if(count < k-1){
                curr = curr.next;
                count++;
                continue;
            }
            ListNode next = curr.next;
            ListNode temp = start;
            while(temp != null && temp != next){
                ListNode n1 = temp.next;
                temp.next = prev;
                prev = temp;
                temp = n1;
            }
            prevTail.next = prev;
            prevTail = start;
            
            count = 0;
            prev = null;
            start = null;
            curr = next;
        }
        prevTail.next = start;
        return res1.next;
    }

}
