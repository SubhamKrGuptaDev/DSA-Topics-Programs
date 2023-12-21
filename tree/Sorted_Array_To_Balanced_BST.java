/**
 *
 * Problem Description
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 *
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of array <= 100000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a root node of the Binary Search Tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A : [1, 2, 3]
 * Input 2:
 *
 *  A : [1, 2, 3, 5, 10]
 *
 *
 * Example Output
 * Output 1:
 *
 *       2
 *     /   \
 *    1     3
 * Output 2:
 *
 *       3
 *     /   \
 *    2     5
 *   /       \
 *  1         10
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You need to return the root node of the Binary Tree.
 *
 *
 */

package tree;

public class Sorted_Array_To_Balanced_BST {

    public TreeNode sortedArrayToBST(final int[] A) {
        return builderBST(A, 0, A.length-1);
    }
    // Find Mid Element
    private TreeNode builderBST(int[] A, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = builderBST(A, start, mid - 1);
        root.right = builderBST(A, mid + 1, end);
        return root;
    }

    // Other Solution
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        TreeNode node = new TreeNode(nums[(l + r) / 2]);
        node.left = helper(nums, l, (l + r) / 2 - 1);
        node.right = helper(nums, (l + r) / 2 + 1, r);
        return node;
    }

    public static void main(String[] args) {

    }

}
