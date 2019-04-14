package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int getMinimumDifference(TreeNode root) {
        int dif = Integer.MAX_VALUE;
        Stack<TreeNode> s = new Stack<>();
        TreeNode walker = root;
        // if (root.left == null) {
        //     return Math.min(dif, root.right.val - root.val);
        // } else if (root.right == null) {
        //     return Math.min(dif, root.val - root.left.val);
        // }
        TreeNode pre = null;
        while (walker != null || !s.isEmpty()) {
            if (walker != null) {
                s.push(walker);
                walker = walker.left;
            } else {
                walker = s.pop();
                if (pre != null) {
                    dif = Math.min(dif, walker.val - pre.val);
                }
                pre = walker;
                walker = walker.right;
            }
        }

        return dif;
    }

}

public class getMinimumDifference_iter {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            int ret = new Solution().getMinimumDifference(root);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}