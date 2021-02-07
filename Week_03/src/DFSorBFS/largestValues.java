package DFSorBFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class largestValues {

    //广度优先BFS， 按层级遍历，找出每层最大值加入List即
    public List<Integer> largestValuesOne(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                max = Math.max(poll.val, max);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    //深度都是DFS,List只存每层最大值，树有几层，List长度就为几，List的索引和层级 level 的索引相对应。
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        _largestValues(0, root, result);
        return result;
    }

    private void _largestValues(int level, TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }

        _largestValues(level + 1, root.left, result);
        _largestValues(level + 1, root.right, result);
    }
}
