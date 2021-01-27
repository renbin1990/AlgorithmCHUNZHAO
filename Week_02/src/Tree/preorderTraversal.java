package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class preorderTraversal {

    public static void main(String[] args) {
        //使用栈
        preorderTraversalOne(new TreeNode());
        //递归
        preorderTraversalTwo(new TreeNode());
    }

    private static List<Integer> preorderTraversalTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(list,root);
        return list;
    }

    private static void recursion(List<Integer> list, TreeNode root) {
        if (root==null){
            return;
        }

        recursion(list,root.left);
        recursion(list,root.right);
        list.add(root.val);

    }

    public static List<Integer> preorderTraversalOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode>  stack = new Stack<>();

        while (root!= null || !stack.empty()){
            while (root!= null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop().right;
        }
        return list;
    }
}
