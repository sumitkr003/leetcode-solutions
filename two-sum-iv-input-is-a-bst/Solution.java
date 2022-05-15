// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> nodes = new ArrayList<>();
        traverseBST(root, nodes);
        int i=0, j=nodes.size() - 1;
        while(i < j){
            int sum = nodes.get(i) + nodes.get(j);
            if(sum == k) return true;
            else if(sum > k) j--;
            else i++;
        }
        return false;
    }
    
    public void traverseBST(TreeNode root, ArrayList<Integer> nodes){
        if(root == null) return;
        
        traverseBST(root.left, nodes);
        nodes.add(root.val);
        traverseBST(root.right, nodes);
    }
}