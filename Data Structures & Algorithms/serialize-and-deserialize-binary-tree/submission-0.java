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

public class Codec {
     
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
  StringBuilder sb = new StringBuilder();
      serializedDfs(root, sb);
  return sb.toString();
    }

    private void serializedDfs(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");

        serializedDfs(node.left, sb);
        serializedDfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
 
             List<String> list = new ArrayList<>(Arrays.asList(arr));
        return deserializeDfs(list);
    }

private TreeNode deserializeDfs(List<String> list) {
        if (list.get(0).equals("N")) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);

        node.left = deserializeDfs(list);
        node.right = deserializeDfs(list);

        return node;
    }
}
