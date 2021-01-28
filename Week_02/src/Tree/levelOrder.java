package Tree;

import java.util.*;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *
 */
public class levelOrder {

    public static void main(String[] args) {
        //队列
        levelOrderOne(new Node());
        //递归
        levelOrderTwo(new Node());
    }

    private static List<List<Integer>> levelOrderTwo(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root!= null){
            traversal(root,list,0);
        }
        return list;
    }

    //level层数
    private static void traversal(Node root, List<List<Integer>> list,int level) {
        if (list.size()<=level){
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.val);

        for (Node node:root.children){
            traversal(node,list,level+1);
        }
    }


    public static List<List<Integer>> levelOrderOne(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node pop = stack.poll();
                temp.add(pop.val);
                stack.addAll(pop.children);
            }
            list.add(temp);
        }
        return list;
    }


    //错误
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node pop = stack.pop();
                temp.add(pop.val);
                for (Node node:pop.children){
                    if (node  !=null ){
                        // 将相同节点孩子加入队列
                        stack.push(node);
                    }
                }
            }
            Collections.reverse(temp);
            list.add(temp);
        }
        return list;
    }
}
