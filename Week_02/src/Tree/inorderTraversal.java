package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class inorderTraversal {
    public static void main(String[] args) {
        //使用栈就行中序遍历
        inorderTraversalOne(new TreeNode());

        //使用递归遍历
        inorderTraversalTwo(new TreeNode());
    }

    //   递归终结条件
    //   处理当前层逻辑
    //   下探到下一层
    //   清理当前层
    private static List<Integer> inorderTraversalTwo(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root,list);
        return list;
    }

    private static void recursion(TreeNode root, List<Integer> list) {
        //   递归终结条件
        if (root==null){
            return;
        }
        recursion(root.left,list);
        list.add(root.val);
        recursion(root.right,list);
    }

    public  static List<Integer> inorderTraversalOne(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root!= null || !stack.empty()){
            while (root!= null){
                //当前节点入栈
                stack.push(root);
                root = root.left;
            }

            //取出入栈节点
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}
