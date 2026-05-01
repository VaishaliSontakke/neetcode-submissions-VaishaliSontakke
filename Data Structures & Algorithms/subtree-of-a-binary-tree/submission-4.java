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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null ){
            return true;
        }
        if(root == null || subRoot == null){
            return false; 
        }
        // if root and subroot val same check equal tree
        if(root.val == subRoot.val){
            if (isEqual(root, subRoot)){
                return true;
            }
        }

        // check if subtree present in left or subtree present in right.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isEqual(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }

        if (root1.val == root2.val){
            return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        }
        return false;
    }

    
}
