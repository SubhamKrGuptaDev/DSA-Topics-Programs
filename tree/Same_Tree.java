/**
 *
 * Given the roots of two binary trees p and q, write a function to check if they
 * are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -10^4 <= Node.val <= 10^4
 *
 *
 *
 */


package tree;

import java.util.Stack;

public class Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeStack(TreeNode p, TreeNode q) {
        Stack<TreeNode> pSt = new Stack<>();
        Stack<TreeNode> qSt = new Stack<>();

        pSt.push(p);
        qSt.push(q);

        while(!pSt.isEmpty() && !qSt.isEmpty()) {
            TreeNode pCur = pSt.pop();
            TreeNode qCur = qSt.pop();

            if(pCur == null && qCur == null) continue;
            if(pCur == null || qCur == null || pCur.val != qCur.val) return false;

            pSt.push(pCur.left);
            qSt.push(qCur.left);

            pSt.push(pCur.right);
            qSt.push(qCur.right);
        }


        return pSt.isEmpty() && qSt.isEmpty();
    }

    public static void main(String[] args) {

    }

}
