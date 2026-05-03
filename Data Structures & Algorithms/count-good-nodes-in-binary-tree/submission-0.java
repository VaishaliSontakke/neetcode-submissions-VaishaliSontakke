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
    int countOfGoodN = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return countOfGoodN;
    }


    public void dfs(TreeNode root, int maxSoFar){
        if(root == null){
            return;
        }
        if(root.val >= maxSoFar){
            countOfGoodN++;
            maxSoFar = root.val;
        }
        dfs(root.left, maxSoFar);
        dfs(root.right, maxSoFar);
    }
}
