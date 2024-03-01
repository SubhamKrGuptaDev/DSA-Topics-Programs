/**
 *
 * Given a binary tree, find the largest value in each level.
 *
 * Example 1:
 *
 * Input :
 *         1
 *        / \
 *       2   3
 *
 * Output : 1 3
 * Explanation :
 * There are two levels in the tree :
 * 1. {1}, max = 1
 * 2. {2, 3}, max = 3
 * Example 2:
 *
 * Input :
 *         4
 *        / \
 *       9   2
 *      / \   \
 *     3   5   7
 *
 * Output : 4 9 7
 * Explanation :
 * There are three levels in the tree:
 * 1. {4}, max = 4
 * 2. {9, 2}, max = 9
 * 3. {3, 5, 7}, max=7
 * Your task :
 * You don't need to read input or print anything. Your task is to complete the function
 * largestValues() which takes the root node of the tree as input and returns a vector
 * containing the largest value in each level.
 *
 * Expected Time Complexity : O(n) , where n = number of nodes
 * Expected Auxiliary Space : O(n) , where n = number of nodes
 *
 * Constraints :
 * 1 ≤ Number of nodes ≤ 10^5
 *
 *
 *
 */



package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Largest_value_in_each_level {

    public ArrayList<Integer> largestValues(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            int max = -1;
            for(int i=0; i<n; i++) {
                TreeNode temp = q.remove();

                max = Math.max(max, temp.val);

                if(temp.left != null) {
                    q.add(temp.left);
                }

                if(temp.right != null) {
                    q.add(temp.right);
                }

            }
            result.add(max);
        }

        return result;
    }

}
