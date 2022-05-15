// https://leetcode.com/problems/binary-tree-right-side-view

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            
            if(node.left != null){
                temp.push(node.left);
            }
            
            if(node.right != null){
                temp.push(node.right);
            }
            
            if(st.isEmpty()){
                ans.add(node.val);
                while(!temp.isEmpty()){
                    st.push(temp.pop());
                }
            }
        }
        
        return ans;
    }
}