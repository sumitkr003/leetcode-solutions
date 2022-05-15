// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        
        ListNode beforeHead = null, afterHead = null, before = null, after = null;
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                if(before != null) before.next = curr;
                if(beforeHead == null) beforeHead = curr;
                before = curr;
            }else{
                if(after != null) after.next = curr;
                if(afterHead == null) afterHead = curr;
                after = curr;
            }
            curr = curr.next;
        }
        
        if(before != null) before.next = afterHead;
        if(after != null) after.next = null;
        return beforeHead != null ? beforeHead : afterHead;
    }
}