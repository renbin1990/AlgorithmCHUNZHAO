学习笔记

一、树、二叉树、二叉搜索树
    
        树和图的区别：
        树：没用环，下面元素不会有交集   linkedList是特殊化的tree
            public class Tree.TreeNode {
                private int val;
                private Tree.TreeNode left,right;
            
                public Tree.TreeNode(int val){
                    this.val = val;
                    this.left = null;
                    this.right = null;
                }
            }
        图：节点有环                  tree是特殊化的图Graph
        
        二叉树：每个分支最多只有两个节点的树
        遍历方式：
                递归（简单）
                    树一般都是用递归，它的结点和树本身它的数据结构都是用递归来定义的
                    递归类似于循环，通过函数来进行的循环
                    对没有任何重复性的问题 那么它的复杂度是客观存在的 只能有多少复杂代码 就写多少复杂代码 否则可以递归完成
                    找重复性可以用高中的数学归纳法来列出 n=1, n=2, n=3… 然后分析mutual exclusive, complete exhaustive
                    递归四步：
                        递归终结条件
                        处理当前层逻辑
                        下探到下一层
                        清理当前层
                循环遍历（复杂）
                前序遍历( Pre-order ) : 根 - 左 - 右
                中序遍历( In-order ) : 左 - 根 - 右
                后序遍历( Post-order ) : 左 - 右 - 根  
                    核心代码：
                        private static void recursion(List<Integer> list, TreeNode root) {
                            if (root==null){
                                return;
                            }
                            list.add(root.val);     //放在第一行就是前序排序，第二行就是中序排序，然后就是后续
                            recursion(list,root.left);
                            recursion(list,root.right);
                        }
            

        二叉搜索树:有序二叉树 (Ordered Binary Tree)、排序二叉树(Sorted Binary Tree)，是指一颗空树或具有下列性质的二叉树:
                1.左子树上所有节点的值均小于它的根节点的值
                2.右子树上所有节点的值均大于它的根节点的值
                3.以此类推：左、右子树叶分别为二叉查找树（这就是 重复性！）
                4.中序遍历：是升序遍历

                常见操作：查询 O(Logn)
                        插入 O(Logn)
                        删除 O(Logn)
                极端情况:只有右节点或者只有左节点，退化成了链表，所有查找是O(n)
                二叉树演示链接：https://visualgo.net/zh/bst
        
        使用栈进行前中后序遍历:
                完成教程:https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/zhuan-ti-jiang-jie-er-cha-shu-qian-zhong-hou-xu--2/
                前序遍历( Pre-order ) : 根 - 左 - 右
                    前序后序遍历，唯一区别就是， 一个一直向左， 一个一直向右
                    核心代码：
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
                后序遍历( Post-order ) : 左 - 右 - 根
                    核心代码：
                             while (root!= null || !stack.empty()){
                                while (root!= null){
                                    list.add(root.val);
                                    stack.push(root);
                                    root = root.left;
                                }
                    
                                TreeNode curr = stack.pop();
                                root = curr.right;
                            }
                中序遍历( In-order ) : 左 - 根 - 右
                    核心代码：
                         while (root != null || !stack.isEmpty()) {
                            while (root != null) {
                                stack.push(root);
                                root = root.left;
                            }
                            root = stack.pop();
                            res.add(root.val);
                            root = root.right;
                        }















