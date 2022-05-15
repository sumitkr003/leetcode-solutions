// https://leetcode.com/problems/binary-tree-paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        return solve(root, "");
    }
    
    public List<String> solve(TreeNode root, String str){
        if(root.left == null && root.right == null){
            List<String> list = new ArrayList<>();
            str += root.val;
            list.add(str);
            return list;
        }
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        if(root.left != null) left = solve(root.left, str + root.val + "->");
        if(root.right != null) right = solve(root.right, str + root.val + "->");
        
        List<String> ans = new ArrayList<>();
        for(String s : left) ans.add(s);
        for(String s : right) ans.add(s);
        return ans;
    }
}