/**
 *
 * Problem Description
 * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an integer, representing the Bth element.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *
 *             2
 *           /   \
 *          1    3
 * B = 2
 * Input 2:
 *
 *
 *             3
 *            /
 *           2
 *          /
 *         1
 * B = 1
 *
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 * 2nd element is 2.
 * Explanation 2:
 *
 * 1st element is 1.
 *
 *
 *
 */


package tree;

public class Kth_Smallest_Element_In_BST {
    int ans = 0;
    int count = 0;
    public int kthsmallest(TreeNode A, int B) {
        inOrder(A,B);
        return ans;
    }

    private void inOrder(TreeNode root, int val) {
        if(root == null) return;
        inOrder(root.left, val);
        count++;
        if(count == val) {
            ans = root.val;
            return;
        }
        inOrder(root.right, val);
    }


    public static void main(String[] args) {

    }

}
