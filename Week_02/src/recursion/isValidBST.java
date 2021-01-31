package recursion;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class isValidBST {

    public void main(String[] args) {
        isValidBSTOne(new TreeNode());
        isValidBSTTwo(new TreeNode());
    }

    private  TreeNode pre = null;

    private  boolean isValidBSTTwo(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBSTTwo(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;

        boolean right = isValidBSTTwo(root.right);

        return left && right;
    }

    public static boolean isValidBSTOne(TreeNode root) {
        return recursionisValidBSTOne(root, null, null);
    }

    private static boolean recursionisValidBSTOne(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }

        if (upper != null && val >= upper) {
            return false;
        }

        if (!recursionisValidBSTOne(root.right, val, upper)) {
            return false;
        }

        if (!recursionisValidBSTOne(root.left, lower, val)) {
            return false;
        }

        return true;
    }
}
