// https://leetcode.com/problems/symmetric-tree

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if((root.left == null || root.right == null) && root.left != root.right) return false;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        
        left.add(root.left);
        right.add(root.right);
        while(left.size() > 0 && right.size() > 0){
            TreeNode node1 = left.remove();
            TreeNode node2 = right.remove();
            // System.out.println(node1.val + " " + node2.val);
            if((node1 == null || node2 == null) && node1 != node2) return false;
            if(node1 != null && node2 != null && node1.val != node2.val) return false;
            
            if(node1 != null){
                left.add(node1.left);
                left.add(node1.right);
            }
            
            if(node2 != null){
                right.add(node2.right);
                right.add(node2.left);
            }
        }
        
        return left.size() == right.size();
    }
    
    
}