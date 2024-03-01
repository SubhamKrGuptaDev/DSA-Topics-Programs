/**
 *
 * Link - https://leetcode.com/problems/cousins-in-binary-tree/description/
 *
 * Given the root of a binary tree with unique values and the values of two
 * different nodes of the tree x and y, return true if the nodes corresponding
 * to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth
 * k node are at the depth k + 1.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 1 <= Node.val <= 100
 * Each node has a unique value.
 * x != y
 * x and y are exist in the tree.
 *
 *
 */




package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Cousins_in_Binary_Tree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return false;

        Queue<TreeNode> q = new LinkedList<>();

        // Avoid Root Node
        if(root.left != null)
            q.add(root.left);
        if(root.right != null)
            q.add(root.right);

        while(!q.isEmpty()) {
            int n = q.size();
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<n; i++) {
                TreeNode temp = q.remove();
                // Check Same Parent with Cousins.
                if(temp.left != null && temp.right != null) {
                    if((temp.left.val == x || temp.right.val == x) && (temp.right.val == y || temp.left.val == y))
                        return false;
                }
                // Add left value
                if(temp.left != null) {
                    q.add(temp.left);
                    set.add(temp.left.val);
                }
                // Add right value
                if(temp.right != null) {
                    q.add(temp.right);
                    set.add(temp.right.val);
                }
            }
            System.out.println(set);
            // check those are present in set or not
            if(set.contains(x) && set.contains(y)) return true;
            if(set.contains(x) || set.contains(y)) return false;
        }

        return false;
    }

}
