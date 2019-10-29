package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// bad input: [8,10,12] [8,5,1,7] [8] [8,5]
// [8,5,1,7,10,12]
public class ConstructBSTFromPreTraversal1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return rec(preorder, 0, preorder.length-1);
    }
    private TreeNode rec(int[] pre, int begin, int end) {
        if (begin > end) return null;
        int rootVal = pre[begin];
        TreeNode node = new TreeNode(rootVal);
        if (begin == end) return node;
        int nextGreater = end+1;
        for (int i = begin+1; i <= end; i++) {
            if (pre[i] > rootVal) {
                nextGreater = i;
                break;
            }
        }
        node.left = rec(pre, begin+1, nextGreater-1);
        node.right = rec(pre, nextGreater, end);
        return node;
    }

    public TreeNode bstFromPreorder_clumsy(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;
        int lend = -1;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > preorder[0]) {
                lend = i;
                break;
            }
        }
        if (lend != -1) {  // has right tree
            constructRight(preorder, lend, preorder.length - 1, root);
            if (lend != 1) {  // has left tree
                constructLeft(preorder, 1, lend - 1, root);
            }
        } else {
            lend = preorder.length - 1;
            constructLeft(preorder, 1, lend, root);
        }
        return root;
    }

    private void construct(int[] preorder, int begin, int end, TreeNode par, boolean isLeft) {
        TreeNode node = new TreeNode(preorder[begin]);
        if (isLeft) par.left = node;
        else par.right = node;
        if (end == begin) return;
        int lend = -1;
        for (int i = begin + 1; i <= end; i++) {
            if (preorder[i] > preorder[begin]) {
                lend = i;
                break;
            }
        }
        if (lend != -1) {  // has right child
            constructRight(preorder, lend, end, node);
            if (lend != begin + 1) constructLeft(preorder, begin + 1, lend - 1, node);
        } else {
            lend = end;
            constructLeft(preorder, begin + 1, lend, node);
        }
    }

    private void constructLeft(int[] preorder, int begin, int end, TreeNode par) {
        construct(preorder, begin, end, par, true);
    }

    private void constructRight(int[] preorder, int begin, int end, TreeNode par) {
        construct(preorder, begin, end, par, false);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] preorder = stringToIntegerArray(line);

            TreeNode ret = new ConstructBSTFromPreTraversal1008().bstFromPreorder(preorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
