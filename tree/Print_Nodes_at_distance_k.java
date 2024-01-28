package tree;

public class Print_Nodes_at_distance_k {

    void printKthNode(TreeNode node,  int k) {
        if(node == null) return;

        if(k == 0) {
            System.out.print(node.val + " ");
        }
        else {
            printKthNode(node.left, k-1);
            printKthNode(node.right, k-1);
        }
    }

}
