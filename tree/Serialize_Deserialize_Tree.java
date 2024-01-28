package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_Deserialize_Tree {

    int index = 0;

    public TreeNode deseriealizePreOrder(ArrayList<Integer> arr) {
        // if array is completed
        if(index == arr.size())
            return null;

        // take value
        int val = arr.get(index);
        index++;

        // if any child null
        if(val == -1)
            return null;

        // Tree Construct
        TreeNode node = new TreeNode(val);
        node.left = deseriealizePreOrder(arr);
        node.right = deseriealizePreOrder(arr);
        return node;
    }

    public void serializePreOrder(TreeNode head, ArrayList<Integer> arr) {
        if(head == null) {
            arr.add(-1);
            return;
        }
        arr.add(head.val);
        TreeNode left = head.left;
        TreeNode right = head.right;
    }

    // PreOrder
    public TreeNode solve(ArrayList<Integer> A) {
        int n = A.size();
        Queue<TreeNode> queue = new LinkedList<>();
        if(A.get(0) == -1) return null;

        TreeNode ans = new TreeNode(A.get(0));
        queue.add(ans);

        for(int i=1; i<n; i++) {
            TreeNode temp = queue.poll();
            TreeNode left = null;
            TreeNode right = null;
            if(A.get(i) != -1) {
                left = new TreeNode(A.get(i));
                queue.add(left);
            }
            i++;
            if(A.get(i) != -1) {
                right = new TreeNode(A.get(i));
                queue.add(right);
            }
            temp.left = left;
            temp.right = right;
        }

        return ans;
    }

}
