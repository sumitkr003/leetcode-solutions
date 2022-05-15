// https://leetcode.com/problems/remove-nth-node-from-end-of-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = Reverse(head);
        head = DeleteNode(head, n);
        return Reverse(head);
    }
    
    public ListNode DeleteNode(ListNode head, int n){
        ListNode curr = head;
        ListNode prev = null;
        
        while(n > 0 && curr != null){
            n--;
            if(n == 0){
                if(prev == null){
                    head = curr.next;
                }else{
                    prev.next = curr.next;
                }
                break;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        return head;
    }
    
    public ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if(curr == null){
                head = prev;
            }
        }
        
        return head;
    }
}