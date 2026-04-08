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
           if(root==null)return false;
               if (isSameSubTree(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameSubTree(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if(a== null || b==null) return false;
        if(a.val != b.val) return false;

        return isSameSubTree(a.left, b.left) && isSameSubTree(a.right, b.right);
    }
}
