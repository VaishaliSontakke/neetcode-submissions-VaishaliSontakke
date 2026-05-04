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
    int maxSum1 = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        int result = maxSum(root);
        return Math.max(maxSum1, result);
    }

    private int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int sumR = maxSum(root.right);
        int sumL = maxSum(root.left);
        int totalsum = root.val + sumR + sumL;
        if(totalsum < root.val){
            totalsum = root.val;
        }

        if(totalsum > maxSum1){
            maxSum1 = totalsum;
        }

        return Math.max(root.val + Math.max(sumR, sumL), root.val);
    }
}
