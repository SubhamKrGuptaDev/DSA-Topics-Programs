package tree;

public class CountHeightOfTree {

    public int countHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(countHeight(root.left), countHeight(root.right)) + 1;
    }

    public static void main(String[] args) {

    }

}
