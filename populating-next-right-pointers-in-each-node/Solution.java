// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        root.next = null;
        Stack<Node> currLevel = new Stack<>();
        ArrayList<Node> nextLevel = new ArrayList<>();
        currLevel.add(root);
        
        while(!currLevel.isEmpty()){
            Node node = currLevel.pop();
            if(node.left != null) nextLevel.add(node.left);
            if(node.right != null) nextLevel.add(node.right);
            
            if(currLevel.isEmpty()){
                for(int i=0;i<nextLevel.size();i++){
                    if(i != nextLevel.size() - 1) nextLevel.get(i).next = nextLevel.get(i+1);
                    else nextLevel.get(i).next = null;
                    currLevel.add(nextLevel.get(nextLevel.size() - i - 1));
                }
                nextLevel = new ArrayList<>();
            }
        }
        
        return root;
    }
}