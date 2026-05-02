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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        int level=0;
        while(!q1.isEmpty()){
            int n = q1.size();
            TreeNode prev = null;
            for(int i=0; i<n ; i++){
                TreeNode node1 = q1.peek();
                q1.remove();
                if(node1 == null){
                    continue;
                }
                if(node1.left != null){
                    q1.add(node1.left);
                }
                if(node1.right != null){
                    q1.add(node1.right);
                }
                prev = node1;
            }
            if(prev != null){
                result.add(prev.val);
            }
            level++;
        }
        return result;
    }
}
