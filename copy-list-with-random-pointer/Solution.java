// https://leetcode.com/problems/copy-list-with-random-pointer

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        Node newHead = new Node(head.val);
        Node curr = head;
        Node newCurr = newHead;
        HashMap<Node, Node> map = new HashMap<>();
        
        while(curr != null){
            Node temp = null; 
            if(curr.next != null){
                temp = new Node(curr.next.val);   
            }
            newCurr.next = temp;
            newCurr.random = curr;
            
            map.put(curr, curr.next);
            curr.next = newCurr;
            
            newCurr = temp;
            curr = map.get(curr);
        }
        
        newCurr = newHead;
        while(newCurr != null){
            if(newCurr.random != null && newCurr.random.random != null){
                newCurr.random = newCurr.random.random.next;    
            }else{
                newCurr.random = null;
            }
             
            newCurr = newCurr.next;
        }
        
        curr = head;
        while(curr != null){
            curr.next = map.get(curr);
            curr = curr.next;
        }
        
        return newHead;
    }
}