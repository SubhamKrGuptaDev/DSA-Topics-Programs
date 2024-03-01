package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row {

    // Level Order Traversal
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++) {
                TreeNode temp = q.remove();
                max = Math.max(max, temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);

            }

            result.add(max);
        }

        return result;
    }

    // DFS
    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, 0, ret);
        return ret;
    }

    private void dfs(TreeNode root, int row, List<Integer> ret) {
        if (root == null) {
            return;
        }
        if (ret.size() == row) {
            ret.add(root.val);
        } else {
            ret.set(row, Math.max(ret.get(row), root.val));
        }
        dfs(root.left, row + 1, ret);
        dfs(root.right, row + 1, ret);
    }

}
