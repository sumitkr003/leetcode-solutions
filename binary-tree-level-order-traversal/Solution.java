// https://leetcode.com/problems/binary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        List<Integer> x = new ArrayList<>();
        x.add(root.val);
        ans.add(x);
        
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        st.add(root);
        
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            
            if(node.right != null){
                temp.add(node.right);
            }
            
            if(node.left != null){
                temp.add(node.left);
            }
            
            if(st.isEmpty()){
                ArrayList<Integer> t = new ArrayList<>();
                while(!temp.isEmpty()){
                    TreeNode n = temp.pop();
                    st.add(n);
                    t.add(n.val);
                }
                
                if(t.size() > 0){
                    ans.add(new ArrayList<>(t));
                }
                
                // temp = new ArrayList<>();
            }
        }
        
        return ans;
    }
}