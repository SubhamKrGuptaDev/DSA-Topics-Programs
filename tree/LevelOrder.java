/**
 *
 * Problem Description
 * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return a 2D integer array denoting the level order traversal of the given binary tree.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [
 *    [3],
 *    [9, 20],
 *    [15, 7]
 *  ]
 * Output 2:
 *
 *  [
 *    [1]
 *    [6, 2]
 *    [3]
 *  ]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  Return the 2D array. Each row denotes the traversal of each level.
 *
 *
 *
 */


package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    private ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == null) return result;

        result.add(new ArrayList<>());
        queue.add(A);

        TreeNode last = A;
        TreeNode temp1 = null;
        while(!queue.isEmpty()) {

            TreeNode q = queue.poll();
            ArrayList<Integer> temp = result.get(result.size() - 1);
            temp.add(q.val);

            if(q.left != null) {
                queue.add(q.left);
                temp1 = q.left;
            }
            if(q.right != null) {
                queue.add(q.right);
                temp1 = q.right;
            }

            if(last == q && !queue.isEmpty()) {
                result.add(new ArrayList<>());
                last = temp1;
            }

        }

        return result;
    }



    public static void main(String[] args) {

    }

}
