package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StrackTraversal {




    /**
     * 前序遍历代码-使用栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root!= null || !stack.empty()){
            //一直向左向下
            while (root!= null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            //左边没了，回到左边的夫级，在向右继续左下走
            TreeNode curr = stack.pop();
            root = curr.right;
        }

        return list;
    }

    /**
     * 后序遍历代码-使用栈
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root!= null || !stack.empty()){
            while (root!= null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            TreeNode curr = stack.pop();
            root = curr.right;
        }

        Collections.reverse(list);
        return list;
    }

    /**
     * 中序遍历代码-使用栈
     * @param root
     * @return
     */
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
