/**
 *
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 *
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B, C <= 109
 *
 *
 *
 * Input Format
 * First argument is head of tree A.
 *
 * Second argument is integer B.
 *
 * Third argument is integer C.
 *
 *
 *
 * Output Format
 * Return the LCA.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *
 *       1
 *      /  \
 *     2    3
 * B = 2
 * C = 3
 * Input 2:
 *
 *       1
 *      /  \
 *     2    3
 *    / \
 *   4   5
 * B = 4
 * C = 5
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  LCA is 1.
 * Explanation 2:
 *
 *  LCA is 2.
 *
 *
 *
 */

package tree;

public class Least_Common_Ancestor {

    public int lca(TreeNode A, int B, int C) {
        // Finding
        if(!find(A, B) || !find(A, C)) return -1;

        // LCA Finding
        TreeNode result = checkLca(A, B, C);

        return result.val;
    }

    private boolean find(TreeNode root, int n) {
        if(root == null) return false;

        if(root.val == n) return true;
        boolean left = find(root.left, n);
        boolean right = find(root.right, n);

        return left || right;
    }

    private TreeNode checkLca(TreeNode root, int n1, int n2) {

        if(root == null) return null;

        if(root.val == n1 || root.val == n2) return root;

        TreeNode left = checkLca(root.left, n1, n2);
        TreeNode right = checkLca(root.right, n1, n2);

        if(left != null && right != null) return root;

        if(left != null) return left;
        if(right != null) return right;

        return null;
    }

    public static boolean findValue(TreeNode root, int val1) {
        if (root == null)
            return false;
        if (root.val == val1)
            return true;
        return (findValue(root.left, val1) || findValue(root.right, val1));
    }


    public static void main(String[] args) {

    }

}
