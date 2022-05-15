// https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size ++;
            curr = curr.next;
        }
        
        curr = head;
        for(int i=1;i<size/2;i++) curr = curr.next;
        
        ListNode middle = curr.next;
        curr.next = null;
        
        return isPalindrome(head, reverse(middle));
    }
    
    public boolean isPalindrome(ListNode curr1, ListNode curr2){
        while(curr1 != null && curr2 != null){
            if(curr1.val != curr2.val) return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}