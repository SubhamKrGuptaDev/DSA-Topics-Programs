/**
 *
 * Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of
 * the Binary tree.
 *
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 *
 * NOTE: The value comes first in the array which have lower level.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 109
 *
 *
 *
 * Input Format
 * First and only argument is a root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [1, 2, 4, 8]
 * Output 2:
 *
 *  [1, 2, 4, 5]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  The Left view of the binary tree is returned.
 *
 *
 *
 */


package tree;

import java.util.ArrayList;

public class Left_View_of_Binary_tree {

    // Left View Recursive Solution
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        return leftView(A, result, 0);
    }

    private ArrayList<Integer> leftView(TreeNode root, ArrayList<Integer> result, int level) {
        if(root != null) {
            if(result.size() <= level) result.add(root.val);
            leftView(root.left, result, level + 1);
            leftView(root.right, result, level + 1);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}