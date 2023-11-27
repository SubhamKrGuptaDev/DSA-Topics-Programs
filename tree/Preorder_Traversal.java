/**
 * Problem Description
 * Given a binary tree, return the preorder traversal of its nodes values.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the preorder traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * * Example Input *
 * Input 1:
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * Input 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * * Example Output *
 * Output 1:
 * <p>
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 6, 2, 3]
 * <p>
 * <p>
 * * Example Explanation *
 * Explanation 1:
 * <p>
 * The Preoder Traversal of the given tree is [1, 2, 3].
 * Explanation 2:
 * <p>
 * The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */

package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder_Traversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        return reOrderItrative(A);
    }

    private ArrayList<Integer> reOrderItrative(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = node;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                result.add(cur.val);
                cur = cur.left;
            } else {
                TreeNode temp = st.pop();
                cur = temp;
                cur = cur.right;
            }
        }

        return result;
    }

    private ArrayList<Integer> reOrder(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return result;
        result.add(node.val);
        reOrder(node.left, result);
        reOrder(node.right, result);
        return result;
    }

    public ArrayList<Integer> preorderTraversalSolution(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (A == null)
            return res;
        stack.push(A);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
