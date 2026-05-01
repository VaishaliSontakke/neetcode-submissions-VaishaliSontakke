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
    public boolean isBalanced(TreeNode root) {
        // -1 for unbalanced tree
        if(checkHeight(root) != -1){
            return true;
        } 
        return false;
    }

    public int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }
        // check if height diff between children is greater than 1, return -1
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(rightHeight, leftHeight) + 1; // return current height
    }
}
