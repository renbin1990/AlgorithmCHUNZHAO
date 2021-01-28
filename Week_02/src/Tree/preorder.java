package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class preorder {

    public static void main(String[] args) {
        //使用栈，迭代法
        preorderOne(new Node());
        //使用递归
        preorderTwo(new Node());
    }

    private static List<Integer> preorderTwo(Node root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    private static void traversal(Node root, List<Integer> list) {
        if (root==null){
            return;
        }

        list.add(root.val);

        for (Node node : root.children){
            traversal(node,list);
        }
    }

    public static List<Integer> preorderOne(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root==null){
            return list;
        }

        stack.push(root);

        while (!stack.empty()){
            Node pop = stack.pop();
            list.add(pop.val);

            for (int i = pop.children.size()-1; i >=0 ; i--) {
                if (pop.children.get(i)!= null){
                    stack.push(pop.children.get(i));
                }
            }
        }

        return list;
    }
}
