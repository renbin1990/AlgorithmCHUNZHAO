package recursion;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class maxDepth {

    public void main(String[] args) {
        //遍历左节点和又节点。找出深度最大的一边
        //    maxDepthOne(new TreeNode());
        maxDepthTwo(new TreeNode());
    }

    private int maxDepthTwo(TreeNode root) {
        return root == null ? 0 : (Math.max(maxDepthTwo(root.left), maxDepthTwo(root.right) + 1));
    }

    public int maxDepthOne(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepthOne(root.left);
        int right = maxDepthOne(root.right);

        return Math.max(left, right) + 1;
    }
}
