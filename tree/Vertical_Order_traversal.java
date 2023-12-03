/**
 *
 * Problem Description
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 *
 *
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 *
 *
 *
 * Problem Constraints
 * 0 <= number of nodes <= 10^5
 *
 *
 *
 * Input Format
 * First and only arument is a pointer to the root node of binary tree, A.
 *
 *
 *
 * Output Format
 * Return a 2D array denoting the vertical order traversal of tree as shown.
 *
 *
 *
 * * Example Input *
 * Input 1:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 * Input 2:
 *
 *       1
 *     /   \
 *    3     7
 *   /       \
 *  2         9
 *
 *
 * * Example Output *
 * Output 1:
 *
 *  [
 *     [2],
 *     [3],
 *     [6, 5],
 *     [7],
 *     [9]
 *  ]
 * Output 2:
 *
 *  [
 *     [2],
 *     [3],
 *     [1],
 *     [7],
 *     [9]
 *  ]
 *
 *
 * * Example Explanation *
 * Explanation 1:
 *
 *  First row represent the verical line 1 and so on.
 *
 *
 *
 */

package tree;

import java.util.*;

public class Vertical_Order_traversal {


    // Recursion with TreeMap Sorting Approach
    /**
     * it does not print the vertical nodes of the same horizontal distance in the correct order.
     */
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        int count = 0;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        getVerticalOrderWithTreeMap(A, count, map);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Iterate Map
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private void getVerticalOrderWithTreeMap(TreeNode root, int count, TreeMap<Integer, ArrayList<Integer>> map) {
        if(root == null) return;

        // It can be throw exception
        ArrayList<Integer> temp = null;
        if(map.containsKey(count)) {
            temp = map.get(count);
        }

        if(temp == null) {
            temp = new ArrayList<>();
            temp.add(root.val);
            map.put(count, temp);
        }
        else {
            temp.add(root.val);
        }

        getVerticalOrderWithTreeMap(root.left, count-1, map);
        getVerticalOrderWithTreeMap(root.right, count+1, map);
    }

    // Queue Solution TC: O(N)

    public ArrayList<ArrayList<Integer>> verticalOrderTraversalQueue(TreeNode A) {
        if(A == null) return null;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        return getVerticalOrder(A,map);
    }

    private ArrayList<ArrayList<Integer>> getVerticalOrder(TreeNode root, HashMap<Integer, ArrayList<Integer>> map) {
        int count = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, count));
        int max = 0, min = 0;
        while(!queue.isEmpty()) {
            Pair temp = queue.remove();
            count = temp.count;
            // HashMap value Insert
            // System.out.println(temp.node.val + " " +temp.count);
            if(!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(temp.node.val);
            // System.out.println(map);
            // Left
            if(temp.node.left != null) {
                queue.add(new Pair(temp.node.left, count - 1));
            }
            // System.out.println(queue);
            // Right
            if(temp.node.right != null) {
                queue.add(new Pair(temp.node.right, count + 1));
            }
            // System.out.println(map);
            if(min > count) min = count;
            else if(max < count) max = count;
        }
        // System.out.println(map);
        // Result ArrayList
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=min; i<=max; i++) {
            if(map.containsKey(i)) {
                result.add(map.get(i));
            }
        }

        return result;
    }

}
