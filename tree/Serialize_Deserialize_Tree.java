package tree;

import java.util.ArrayList;

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

}
