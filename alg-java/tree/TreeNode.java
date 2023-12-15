package tree;

import java.util.*;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 0;
        while (!queue.isEmpty()) {
            // start the current level
            res.add(new ArrayList<Integer>());
            // number of elements in the current level
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.remove();
                res.get(levelNum).add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            levelNum++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5, null, null);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, five, null);
        TreeNode two = new TreeNode(2, four, null);
        TreeNode one = new TreeNode(1, two, three);
        TreeNode fun = new TreeNode();

        List<List<Integer>> res = fun.levelOrder(one);
        System.out.println(res);
    }
    
}
