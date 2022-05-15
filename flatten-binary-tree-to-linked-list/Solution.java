// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

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
    public void flatten(TreeNode root) {
        TreeNode node = solve(root);
        // while(node != null){
        //     System.out.println(node.val + " " + node.left + " " + node.right);
        //     node = node.right;
        // }
    }
    
    public TreeNode solve(TreeNode root){
        if(root == null) return root;
        
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);
        
        TreeNode curr = left;
        while(curr != null && curr.right != null) curr = curr.right;
        
        if(curr == null) return root;
        
        curr.right = right;
        root.right = left;
        root.left = null;
        
        return root;
    }
}