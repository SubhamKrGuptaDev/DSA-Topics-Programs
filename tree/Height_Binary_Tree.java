package tree;

public class Height_Binary_Tree {

    public int findHeightBinaryTree(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(findHeightBinaryTree(node.left),
                findHeightBinaryTree(node.right)) +1;
    }

}
