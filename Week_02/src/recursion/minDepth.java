package recursion;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class minDepth {
    public static void main(String[] args) {

    }

    public int minDepthTwo(TreeNode root){
        if (root==null){
            return 0;
        }

        int left = minDepthTwo(root.left);
        int right = minDepthTwo(root.right);

        //如果左右节点长度都大于0 找他们的最小值，反之，有一个为0，则找他们的最大值是最小深度
        if (left>0 && right>0){
            return Math.min(left,right)+1;
        }else {
            return Math.max(left,right)+1;
        }
    }

    public int minDepthOne(TreeNode root) {
        if (root==null){
            return 0;
        }

        int left = minDepthOne(root.left);
        int right = minDepthOne(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (left==0 || right==0) ? left+right+1:Math.min(left,right)+1;
    }

    //，遍历整棵树，记录最小深度
    //对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题。
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left!= null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }

        if (root.right!= null){
            min_depth = Math.min(minDepth(root.right),min_depth);
        }
        return min_depth+1;
    }
}
