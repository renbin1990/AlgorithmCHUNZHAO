package recursion;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class lowestCommonAncestor {
    public static void main(String[] args) {

    }

    //终止条件：
    //当越过叶节点，则直接返回 nullnull ；
    //当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
    public TreeNode lowestCommonAncestorOne(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorOne(root.left, p, q);
        TreeNode right = lowestCommonAncestorOne(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }



    //所有的递归的返回值有4种可能性，null、p、q、公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        //当找到p或者q的是时候就会返回pq
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //如果左右都存在，就说明pq都出现了，这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
        if (left!= null && right!= null){
            return root;
        }

        if (left!=null){
            return left;
        }

        if (right!=null){
            return  right;
        }

        return null;
    }
}
