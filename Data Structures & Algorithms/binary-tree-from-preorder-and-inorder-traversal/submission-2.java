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
      int preIndex = 0;
        Map<Integer, Integer> inorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      
            inorderIndex = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            inorderIndex.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int l, int r){
        if(l>r) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndex.get(rootVal);

        root.left = build(preorder, l, mid-1);
        root.right = build(preorder, mid+1 , r);

        return root;
    }
}
