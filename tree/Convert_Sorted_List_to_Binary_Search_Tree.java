/**
 *
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a
 * height-balanced
 *  binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents
 * the shown height balanced BST.
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in head is in the range [0, 2 * 10^4].
 * -10^5 <= Node.val <= 10^5
 *
 *
 */


package tree;

import linkedlist.ListNode;

public class Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        return buildBSTFromLinkedList(head);
    }

    // build BST
    private TreeNode buildBSTFromLinkedList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.next.val);
        ListNode rightHalf = mid.next.next;
        mid.next = null;
        root.left = buildBSTFromLinkedList(head);
        root.right = buildBSTFromLinkedList(rightHalf);
        return root;
    }

    // Find Mid
    private ListNode findMid(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

    }

}
