/**
 *
 *  Problem Description
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the inorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the postorder traversal of the tree.
 *
 *
 *
 * Output Format
 * Return the root node of the binary tree.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *  A = [2, 1, 3]
 *  B = [2, 3, 1]
 * Input 2:
 *
 *  A = [6, 1, 3, 2]
 *  B = [6, 3, 2, 1]
 *
 *
 * * Example Output *
 * Output 1:
 *
 *    1
 *   / \
 *  2   3
 * Output 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  Create the binary tree and return the root node of the tree.
 *
 *
 */


package tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Binary_Tree_From_Inorder_And_Postorder {

    HashMap<Integer,Integer> map;

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        map = new HashMap<>();

        for(int i=0; i<A.size(); i++) {
            map.put(A.get(i), i);
        }

        return buildBinaryTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
    }

    private TreeNode buildBinaryTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int is, int ie
            , int ps, int pe) {

        if(is > ie || ps > pe) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder.get(pe));

        int index = search(node.val);
        int leftNumber = index - is;

        node.left = buildBinaryTree(inOrder, postOrder, is, index - 1, ps, ps + leftNumber - 1);
        node.right = buildBinaryTree(inOrder, postOrder, index+1, ie, ps + leftNumber, pe - 1);

        return node;
    }

    private int search(int n) {
        return map.get(n);
    }

    public static void main(String[] args) {

    }

}
