/**
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
 * <p>
 * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is head of the binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array, representing the right view of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 1
 * /   \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * /
 * 8
 * Input 2:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * \
 * 4
 * \
 * 5
 * <p>
 * <p>
 * * Example Output *
 * Output 1:
 * <p>
 * [1, 3, 7, 8]
 * Output 2:
 * <p>
 * [1, 3, 4, 5]
 * <p>
 * <p>
 * * Example Explanation *
 * Explanation 1:
 * <p>
 * Right view is described.
 * Explanation 2:
 * <p>
 * Right view is described.
 */

package tree;

import java.util.*;

public class Right_View_of_Binary_tree {

    // Using Deque
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        TreeNode last = A;
        result.add(A.val);
        // TreeNode rightLast = null;
        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }

            if (!queue.isEmpty() && last.equals(cur)) {
                result.add(queue.getLast().val);
                last = queue.getLast();
            }

        }
        return result;
    }

    // Recursive Solution

    int max = -1;
    public List<Integer> solve1(TreeNode A) {
        List<Integer> list = new ArrayList();
        rightView(A, list, 0);
        return list;
    }

    public void rightView(TreeNode A, List<Integer> list, int depth) {
        if (A == null) return;
        if (max < depth) {
            max = depth;
            list.add(A.val);
        }
        rightView(A.right, list, depth + 1);
        rightView(A.left, list, depth + 1);
    }

    // Using Queue
    public List<Integer> solve2(TreeNode A) {
        Queue<TreeNode> q=new LinkedList();
        List<Integer> list=new ArrayList();
        q.offer(A);
        int size;
        TreeNode node;
        while(!q.isEmpty())
        {
            size=q.size();
            for(int i=0;i<size;i++)
            {
                node=q.poll();
                if(i==size-1) list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return list;
    }


    // Main Method
    public static void main(String[] args) {

    }

}
