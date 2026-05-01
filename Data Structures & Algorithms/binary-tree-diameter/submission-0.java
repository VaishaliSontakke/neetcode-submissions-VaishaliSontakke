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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        getDiameterOfTree(root, diameter);
        return diameter[0];
    }

    public int getDiameterOfTree(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }
        int rightHeight = getDiameterOfTree(root.right, diameter);
        int leftHeight = getDiameterOfTree(root.left, diameter);
        if(rightHeight + leftHeight > diameter[0]){
            diameter[0] = rightHeight + leftHeight;
        }
        return Math.max(rightHeight, leftHeight) + 1;
    }

}
