// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    public TreeNode root = null;
    public FindElements(TreeNode node) {
        if(node == null){
            return;
        }
        
        root = node;
        node.val = 0;
        recover(node);
    }
    
    public void recover(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.val = root.val * 2 + 1;
        }
        
        if(root.right != null){
            root.right.val = root.val * 2 + 2;
        }
        
        recover(root.left);
        recover(root.right);
    }
    
    public boolean find(int target) {
        return find(target, root);
    }
    
    public boolean find(int target, TreeNode node){
        if(node == null){
            return false;
        }
        
        if(node.val == target){
            return true;
        }
        
        return find(target, node.left) || find(target, node.right);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */