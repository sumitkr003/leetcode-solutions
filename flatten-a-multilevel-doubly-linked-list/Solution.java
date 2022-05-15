// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
                Node node = flatten(curr.child);
                Node next = curr.next;
                
                curr.next = node;
                node.prev = curr;
                curr.child = null;
                while(node.next != null) node = node.next;
                node.next = next;
                if(next != null) next.prev = node;
                curr = next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}