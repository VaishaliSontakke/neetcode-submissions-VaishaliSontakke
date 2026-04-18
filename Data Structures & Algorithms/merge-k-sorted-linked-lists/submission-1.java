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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return mergeRangeLists(lists, 0, lists.length-1);
    }

    public ListNode mergeRangeLists(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        if(end-start == 1){
            return mergeTwoListsRecursive(lists[start], lists[end]);
        }
        int mid = (start + end)/2;
        ListNode left = mergeRangeLists(lists, start, mid);
        ListNode right = mergeRangeLists(lists, mid+1, end);
        return mergeTwoListsRecursive(left, right);
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }


    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode node1= new ListNode(0); // dummy node
        ListNode res = node1;
        while(l1 != null && l2 != null){
            if(l1.val == l2.val){
                node1.next = l1;
                node1 = node1.next;
                node1.next = l2;
                node1 = node1.next;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1.val < l2.val){
                node1.next = l1;
                node1 = node1.next;
                l1 = l1.next;
            } else {
                node1.next = l2;
                node1 = node1.next;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            node1.next = l1;
        }
        node1.next = l2;
        return res.next;
    }
}
