package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class postorder {
    public static void main(String[] args) {
        //使用栈
        postorderOne(new Node());
        //使用递归
        postorderTwo(new Node());
    }

    private static List<Integer> postorderTwo(Node root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    private static void traversal(Node node, List<Integer> list) {
        if (node==null){
            return;
        }

        for (int i = 0; i < node.children.size(); i++) {
            traversal(node.children.get(i),list);
        }

        list.add(node.val);
    }

    public static List<Integer> postorderOne(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root==null){
            return list;
        }

        stack.push(root);

        while (!stack.empty()){
         Node node = stack.pop();
         list.add(node.val);

            for (int i = 0; i < node.children.size(); i++) {
                if (node.children.get(i)!=null){
                    stack.push(node.children.get(i));
                }
            }
        }

        Collections.reverse(list);
        return list;
    }
}
