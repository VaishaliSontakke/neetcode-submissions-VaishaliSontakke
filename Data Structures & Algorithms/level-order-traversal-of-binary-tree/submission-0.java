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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
           return result;
        }
        int level=0;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
           result.add(new ArrayList<>());
           int n = q1.size();
           for(int i=0; i < n; i++){
                TreeNode node1 = q1.peek();
                q1.remove();
                result.get(level).add(node1.val);
                if(node1.left != null){
                   q1.add(node1.left);
                }
                if(node1.right != null){
                   q1.add(node1.right);
                }
            }
            level++;
        }
        return result;
    }
}
