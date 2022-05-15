// https://leetcode.com/problems/merge-k-sorted-lists

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
        }else if(lists.length == 1){
            return lists[0];
        }
        
        ListNode head = lists[0];
        for(int i=1;i<lists.length;i++){
            head = mergeList(head, lists[i]);
        }
        return head;
    }
    
    public ListNode mergeList(ListNode head1, ListNode head2){
        ListNode newHead = null;
        if(head1 != null && (head2 == null || head1.val < head2.val)){
            newHead = head1;
            head1 = head1.next;
        }else{
            newHead = head2;
            if(head2 != null){
                head2 = head2.next;
            }
        }
        
        ListNode curr = newHead;
        while(head1 != null && head2 != null){
            ListNode next = curr.next;
            if(head1.val < head2.val){
                curr.next = head1;
                ListNode newHead1 = head1.next;
                head1.next = next;
                curr = head1;
                head1 = newHead1;
            }else{
                curr.next = head2;
                ListNode newHead2 = head2.next;
                head2.next = next;
                curr = head2;
                head2 = newHead2;;
            }
        }
        
        if(head1 != null){
            curr.next = head1;
        }else if(head2 != null){
            curr.next = head2;
        }
        
        return newHead;
    }
}