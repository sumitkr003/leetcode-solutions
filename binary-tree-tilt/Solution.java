// https://leetcode.com/problems/binary-tree-tilt

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
    public int findTilt(TreeNode root){
        TiltTree(root);
        // Traverse(root);
        return sumOfNodes(root);
    }
    
    public int TiltTree(TreeNode root){
        if(root == null) return 0;
        
        int leftSum = TiltTree(root.left);
        int rightSum = TiltTree(root.right);
        int sum = root.val + leftSum + rightSum;
        root.val = Math.abs(leftSum - rightSum);
        // System.out.print(sum + " ");
        return sum;
    }
    
    public int sumOfNodes(TreeNode root){
        if(root == null) return 0;
        
        return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
    }
    
    public void Traverse(TreeNode root){
        if(root == null) return;
        
        // System.out.print(root.val + " ");
        Traverse(root.left);
        Traverse(root.right);
    }
    
    
    
}