// https://leetcode.com/problems/binary-tree-postorder-traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> ans = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode A) {
        solve(A);
        return ans;
    }
    
    public void solve(TreeNode node){
        if(node == null){
            return;
        }
        
        solve(node.left);
        solve(node.right);
        ans.add(node.val);
    }
}