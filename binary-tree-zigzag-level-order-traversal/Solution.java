// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        boolean flag = true;
        Stack<TreeNode> st = new Stack<>();
        ArrayList<TreeNode> temp = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(flag){
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }else{
                if(node.right != null){
                    temp.add(node.right);
                }
                if(node.left != null){
                    temp.add(node.left);
                }
            }
            list.add(node.val);
            
            if(st.isEmpty()){
                ans.add(list);
                for(TreeNode n : temp){
                    st.push(n);
                }
                temp = new ArrayList<>();
                list = new ArrayList<>();
                flag = !flag;
            }
        }
        
        return ans;
    }
}