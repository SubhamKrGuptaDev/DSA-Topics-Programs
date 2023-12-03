/**
 *
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have
 * values 7, 4, and 1.
 * Example 2:
 *
 * Input: root = [1], target = 1, k = 3
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 *
 *
 *
 */


package tree;


import java.util.ArrayList;
import java.util.List;

public class All_Nodes_Distance_K_in_Binary_Tree {

    List<Integer> list = new ArrayList<>();
    public List<Integer> distanceK(TreeNode node, TreeNode target, int k) {
        helperK(node, target.val, k);
        return list;
    }

    private int helperK(TreeNode root, int target, int k) {
        if(root == null) return k;
        if(root.val == target) {
            storeValue(root, k);
            return k - 1;
        }
        int valK1 = helperK(root.left, target, k);
        int valK2 = helperK(root.right, target, k);
        if(valK1 != valK2) {
            if(Math.min(valK1, valK2) == 0) {
                list.add(root.val);
                return k;
            }
            if(valK1 < k) storeValue(root.right, valK1 - 1);
            else storeValue(root.left, valK2 - 1);
            return Math.min(valK1, valK2) - 1;
        }

        return k;
    }

    private void storeValue(TreeNode root, int k) {
        if(root == null) return;
        if(k == 0) list.add(root.val);
        else {
            storeValue(root.left, k - 1);
            storeValue(root.right, k -1);
        }
    }

}
