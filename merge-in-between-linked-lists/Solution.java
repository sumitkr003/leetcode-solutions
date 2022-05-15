// https://leetcode.com/problems/merge-in-between-linked-lists

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode firstList1 = null, lastList1 = null, lastList2 = null;
        ListNode curr = list2;
        while(curr != null){
            lastList2 = curr;
            curr = curr.next;
        }
        
        curr = list1;
        int count = 1;
        while(curr != null){
            if(count == a) firstList1 = curr;
            if(count > b){
                lastList1 = curr.next;
                break;
            }
            count ++;
            curr = curr.next;
        }
        
        firstList1.next = list2;
        lastList2.next = lastList1;
        return list1;
    }
}