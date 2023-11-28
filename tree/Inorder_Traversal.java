package tree;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder_Traversal {

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        return itrativeSolution(A);
    }

    private ArrayList<Integer> itrativeSolution(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    private ArrayList<Integer> recursiveSolution(TreeNode node, ArrayList<Integer> result) {
        if(node == null) return result;
        recursiveSolution(node.left, result);
        result.add(node.val);
        recursiveSolution(node.right, result);
        return result;
    }

    public static void main(String[] args) {

    }

}
