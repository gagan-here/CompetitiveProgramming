package Blind75.Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file
 * or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
 * algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
 * to the original tree structure.
 * <p>
 * Binary tree example :
 *
 * <pre>
 *                1
 *               / \
 *              /   \
 *             2     3
 *                  / \
 *                 /   \
 *                4     5
 * </pre>
 * In serialization, you will be given a binary tree like above and you have to convert it to a string.<br>
 * For above binary tree the string while serializing would be <b>1 2 3 # # 4 5 # # # #</b> <br>
 * Here, # means the root node doesn't have a left or right subtree
 * <p>
 * Similarly, while deserializing the string "1 2 3 # # 4 5 # # # #" should be converted to binary tree like above
 * Here we are using inorder traversal for serialization and deserialization of binary tree
 */
public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static String serialize(TreeNode root) {
        //      1
        //     / \
        //    2   3
        //       / \
        //      4   5

        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n "); // Here we are putting n followed by space for nodes with no left or right subtree
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public static TreeNode deserialize(String data) {
//        1 2 3 # # 4 5 # # # #
        if (data.isEmpty()) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        // Creating a sample tree:
        //      1
        //     / \
        //    2   3
        //       / \
        //      4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serializedData = serialize(root);
        System.out.println("Serialized data: " + serializedData);

        // Deserialize the data back to a tree
        TreeNode deserializedRoot = deserialize(serializedData);
        System.out.println("Deserialization completed.");
    }
}
