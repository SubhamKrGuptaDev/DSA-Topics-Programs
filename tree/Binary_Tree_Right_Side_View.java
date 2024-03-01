/**
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 */



package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();
            TreeNode prev = null;
            for(int i=0; i<n; i++) {
                TreeNode temp = q.remove();
                prev = temp;
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
            result.add(prev.val);
        }

        return result;
    }

}
