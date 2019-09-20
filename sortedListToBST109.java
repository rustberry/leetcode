/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 Given a singly linked list where elements are sorted in ascending order,
 convert it to a height balanced BST.
 */
 // Date: 19-05-12
class Solution {
    private ListNode node;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // return sortedListToBSTRecur(head, null);
        
        this.node = head;
        int s = 0, e = 0;
        while (head != null) {
            head = head.next;
            e++;
        }
        return inorderFastRecur(s, e-1);
    }
    
    private TreeNode sortedListToBSTRecur(ListNode start, ListNode tail) {
        ListNode slow = start;
        ListNode fast = start;
        if (start == tail) return null;
        
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode head = new TreeNode(slow.val);
        
        head.left = sortedListToBSTRecur(start, slow);
        head.right = sortedListToBSTRecur(slow.next, tail);
        
        return head;
    }
    
    // This method computes the length first. 
    // It terminates every recursion with half of the len.
    // With every finish of left subtree's inorderFastRecur, `node` proceedes right;
    private TreeNode inorderFastRecur(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = inorderFastRecur(start, mid - 1);
        
        TreeNode head = new TreeNode(node.val);
        node = node.next;
        head.left = left;
        
        TreeNode right = inorderFastRecur(mid + 1, end);
        head.right = right;
        
        return head;
    }
    
    
}