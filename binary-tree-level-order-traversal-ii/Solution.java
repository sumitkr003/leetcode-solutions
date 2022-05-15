// https://leetcode.com/problems/binary-tree-level-order-traversal-ii

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<TreeNode> nextLevel = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if(root == null) return ans;
        q.add(root);
        temp.add(root.val);
        ans.add(temp);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null) nextLevel.add(node.left);
            if(node.right != null) nextLevel.add(node.right);
            
            if(q.isEmpty()){
                temp = new ArrayList<>();
                for(TreeNode n : nextLevel){
                    q.add(n);
                    temp.add(n.val);
                }
                if(temp.size() > 0) ans.add(temp);
                nextLevel = new ArrayList<>();
            }
        }
        
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            arr.add(ans.get(ans.size() - i - 1));
        }
        return arr;
    }
}