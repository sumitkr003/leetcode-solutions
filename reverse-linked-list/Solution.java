// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, tail = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
            if(curr == null){
                tail = prev;
            }
        }
        
        return tail;
    }
}