// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

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
        Queue<Node> q = new LinkedList<Node>();
        List<Node> nextLevel = new ArrayList<>();
        
        if(root == null) return root;
        root.next = null;
        q.add(root);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left != null) nextLevel.add(node.left);
            if(node.right != null) nextLevel.add(node.right);
            
            if(q.isEmpty()){
                for(int i=0;i<nextLevel.size()-1;i++){
                    nextLevel.get(i).next = nextLevel.get(i+1);
                    q.add(nextLevel.get(i));
                }
                
                if(nextLevel.size() > 0){
                    nextLevel.get(nextLevel.size() - 1).next = null;
                    q.add(nextLevel.get(nextLevel.size() - 1));
                }
                nextLevel = new ArrayList<>();
            }
        }
        
        return root;
    }
}