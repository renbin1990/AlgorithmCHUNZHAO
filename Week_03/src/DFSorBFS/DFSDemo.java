package DFSorBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSDemo {


    /**
     * 深度遍历DFS维护栈写法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderStack(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root==null){
            return allResults;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            int size =stack.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode peek = stack.peek();
                temp.add(peek.val);

                if (peek.right!= null){
                    stack.push(peek.right);
                }

                if (peek.left!= null){
                    stack.push(peek.left);
                }
            }
        }

        return allResults;
    }


    /**
     * 深度遍历DFS递归写法
     * @param root
     * @return
     */
     public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> allResults = new ArrayList<>();
         if (root==null){
             return allResults;
         }
        _travel(0,root,allResults);
         return allResults;
    }

    private void _travel(int level, TreeNode root, List<List<Integer>> allResults) {
        if (level== allResults.size()){
            allResults.add(new ArrayList<>());
        }

        allResults.get(level).add(root.val);
        if (root.left!= null){
            _travel(level+1,root.left,allResults);
        }

        if (root.right!= null){
            _travel(level+1,root.right,allResults);
        }
    }
}
