// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        int count = 1;
        ListNode prev = null, last = null, curr = head;
        while(curr != null){
            if(count == left) break;
            count ++;
            prev = curr;
            curr = curr.next;
        }
        
        while(curr != null){
            last = curr.next;
            if(count == right) break;
            count ++;
            curr = last;
        }
        
        ListNode tempHead = reverse(prev == null ? head : prev.next, right, left);
        if(prev != null) prev.next = tempHead;
        curr = tempHead;
        while(curr != null){
            if(curr.next == null){
                curr.next = last;
                break;
            }
            curr = curr.next;
        }

        return prev == null ? tempHead : head;
    }
    
    public ListNode reverse(ListNode head, int right, int count){
        ListNode prev = head, newHead = head;
        ListNode curr = prev == null ? null : prev.next;
        if(prev != null) prev.next = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            newHead = curr;
            count++;
            if(count == right) break;
            prev = curr;
            curr = next;
        }
        return newHead;
    }
}