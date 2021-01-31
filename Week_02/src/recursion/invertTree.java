package recursion;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 */
public class invertTree {

    public static void main(String[] args) {
        invertTreeOne(new TreeNode());
        invertTreeTwo(new TreeNode());
        invertTreeThree(new TreeNode());
        invertTreeFour(new TreeNode());
    }

    private static TreeNode invertTreeFour(TreeNode root) {
        if (root==null){
            return null;
        }

        //交换当前节点的子元素交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归交换，左右元素的子元素
        invertTreeFour(root.left);
        invertTreeFour(root.right);

        return root;
    }

    //后续遍历
    private static TreeNode invertTreeThree(TreeNode root) {
        if (root==null){
            return null;
        }

        TreeNode treeNodeLeft = invertTreeThree(root.left);
        TreeNode treeNodeRight = invertTreeThree(root.right);

        root.left = treeNodeRight;
        root.right = treeNodeLeft;

        return root;
    }

    //中序遍历
    private static TreeNode invertTreeTwo(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeTwo(root.left);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTreeTwo(root.left);
        return root;
    }

    //左序遍历
    public static TreeNode invertTreeOne(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        //交换左右树的位置
        root.right = invertTreeOne(root.left);
        root.left = invertTreeOne(right);
        return root;
    }
}
