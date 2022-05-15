// https://leetcode.com/problems/serialize-and-deserialize-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        String ans = root.val + " ";
        q.add(root);
        
        while(q.size() > 0){
            TreeNode node = q.remove();
            if(node.left != null){
                q.add(node.left);
                ans += node.left.val + " ";
            }else{
                ans += "null ";
            }
            
            if(node.right != null){
                q.add(node.right);
                ans += node.right.val + " ";
            }else{
                ans += "null ";
            }
        }
        // System.out.println(ans);
        return ans.substring(0, ans.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        
        String[] nodes = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int i=1;
        while(i<nodes.length-1 && list.size() > 0){
            TreeNode temp = list.remove();
            
            // System.out.println(temp.val + " " + nodes[i] + " " + nodes[i+1]);
            if(!nodes[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                temp.left = left;
                list.add(left);
            }
            
            if(!nodes[i+1].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i+1]));
                temp.right = right;
                list.add(right);
            }
            i += 2;
        }
            
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));