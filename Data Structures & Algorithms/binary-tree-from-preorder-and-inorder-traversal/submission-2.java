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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hmap1 = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            hmap1.put(inorder[i], i);
        }
        // store preorder index in global variable(array 0th value)
        int[] preindex = new int[1];
        // pass hashmap to know index in inorder array.
        TreeNode node1 = buildTree1(preorder, 0, preorder.length-1,  preindex, hmap1);
        return node1;
    }

    // process left to right is within condition
    public TreeNode buildTree1(int[] preorder, int left, int right, int[] preindex, HashMap<Integer, Integer> hmap1){
        if(left > right){
            return null;
        }
        int index1 = preindex[0];
        TreeNode node1 = new TreeNode(preorder[index1]);
        // get inorder index of the preorder value at the given index.
        int inorder1 = hmap1.get(preorder[index1]);
        // process next index from preorder array.
        preindex[0]++;
        // build left tree from inorder index left, inorder-1
        node1.left = buildTree1(preorder, left, inorder1-1 , preindex, hmap1);
        // build right tree from inorder+1 till right index in inorder.
        node1.right = buildTree1(preorder, inorder1+1, right, preindex ,hmap1);
        return node1;
    }
}
