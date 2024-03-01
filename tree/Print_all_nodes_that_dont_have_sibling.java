/**
 *
 * Link - https://www.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1?page=1&difficulty%5B%5D=0&category%5B%5D=Tree&sortBy=submissions
 *
 * Given a Binary Tree of size n, find all the nodes that don't have any siblings.
 * You need to return a list of integers containing all the nodes that don't have a
 * sibling in sorted order.
 *
 * Two nodes are said to be siblings if they are present at the same level, and their
 * parents are the same.
 *
 * Note: The root node can not have a sibling so it cannot be included in our answer.
 *
 *
 * Expected Time Complexity: O(nlogn)
 * Expected Auxiliary Space: O(Height of the tree)
 *
 *
 * Constraints:
 * 1 ≤ n ≤ 10^4
 * All nodes have distinct values.
 *
 *
 *
 */

package tree;

import java.util.ArrayList;
import java.util.Collections;

public class Print_all_nodes_that_dont_have_sibling {

    public ArrayList<Integer> noSibling(TreeNode node)
    {
        ArrayList<Integer> result = new ArrayList<>();
        // if root is null return -1
        if(node == null) {
            result.add(-1);
            return result;
        }

        findParent(node, result, node);
        // if all have siblings return -1
        if(result.isEmpty()) {
            result.add(-1);
            return result;
        }

        // Sort all then values and return.
        Collections.sort(result);
        return result;
    }

    private void findParent(TreeNode node, ArrayList<Integer> result, TreeNode root) {
        if(node == null) return;

        // if both are null just return it
        if(node.left == null && node.right == null) return;

        // if left is null then add right value
        if(node.left == null) result.add(node.right.val);

        // if right is null then add left value
        if(node.right == null) result.add(node.left.val);

        // Left and Right child call
        findParent(node.left, result, root);
        findParent(node.right, result, root);
    }

}
