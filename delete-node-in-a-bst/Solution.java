// https://leetcode.com/problems/delete-node-in-a-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNode(root, null, key);
    }
    
    public TreeNode deleteNode(TreeNode root, TreeNode parent, int key){
        if(root == null) return root;
        if(root.val == key){
            if(root.left == null || root.right == null){
                TreeNode node = root.left == null ? root.right : root.left;
                // System.out.println(root.val + " " + parent.val);
                return node;
            }
            
            int smallest = findSmallestInRightSide(root.right);
            TreeNode node = new TreeNode(smallest, root.left, root.right);            
            node.right = deleteNode(root.right, root, smallest);
            
            // System.out.println(root.val + " " + node.val);
            return node;
        }else if(root.val > key){
            root.left = deleteNode(root.left, root, key);
        }else{
            root.right = deleteNode(root.right, root, key);
        }
        
        return root;
    }
    
    public int findSmallestInRightSide(TreeNode node){
        if(node.left == null) return node.val;
        return findSmallestInRightSide(node.left);
    }
}