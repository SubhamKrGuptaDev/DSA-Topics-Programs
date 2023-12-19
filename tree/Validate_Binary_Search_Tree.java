/**
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 *
 *
 */



package tree;

import java.util.ArrayList;
import java.util.List;

public class Validate_Binary_Search_Tree {

    // Using Array check BST
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i=1; i<list.size(); i++) {
            if(list.get(i-1) >= list.get(i)) return false;
        }

        return true;
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // Using Recursion Check CST
    boolean found = false;
    public boolean isValidBSTRecursive(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValid(TreeNode root, long leftMax, long rightMin) {
        if(root == null) return true;
        if(leftMax >= root.val || rightMin <= root.val) return false;
        return checkValid(root.left, leftMax, root.val) && checkValid(root.right, root.val, rightMin);
    }

    // Simple Recursive
    private long minVal = Long.MIN_VALUE;
    public boolean isValidBSTSimpleRecursive(TreeNode root) {
        if (root == null) return true;
        if (!isValidBSTSimpleRecursive(root.left)) return false;

        if (minVal >= root.val) return false;

        minVal = root.val;

        if (!isValidBSTSimpleRecursive(root.right)) return false;

        return true;
    }

    public static void main(String[] args) {

    }

}
