学习笔记

一、分治、回溯的实现和特性
    
    分治：本质就是一种特殊的递归
    找最近重复性，将大问题分为子问题分别解决，再组合子问题的结果为最终结果 
        
         private static int divide_conquer(Problem problem,int params) {
            // recursion terminator
            if (problem == NULL) {
                int res = process_last_result();
                return res;
            }
            // prepare data
            subProblems = split_problem(problem)
            //conquer subproblems
            res0 = divide_conquer(subProblems[0])
            res1 = divide_conquer(subProblems[1])
    
            //process and generate the final result
            result = process_result(res0, res1);
            //revert the current level states
            return result;
        }

    回溯：就是不断的下浅到每一层去试，找到结果试完了再回到上一层去试其他的可能性

二、深度优先DFS 和 广度优先BFS搜索
    
    深度优先DFS：从上到下，从左到右，依次遍历。先是左边，然后是右节点，最后根节点，再往右

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

    广度优先BFS：从上到下一层一层的遍历，根-左-右-左左子节点-左右子节点-右左子节点-右右子节点。依次类推
            
                public List<List<Integer>> levelOrder(TreeNode root) {
                    List<List<Integer>> allResults = new ArrayList<>();
                    if (root==null){
                        return allResults;
                    }
            
                    Queue<TreeNode> queue = new LinkedList<>();
                    queue.add(root);
            
                    while (!queue.isEmpty()){
                        int size = queue.size();
                        List<Integer> result = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            TreeNode poll = queue.poll();
                            result.add(poll.val);
            
                            if (poll.left!= null){
                                queue.add(poll.left);
                            }
            
                            if (poll.right!= null){
                                queue.add(poll.right);
                            }
                        }
            
            
                    }
                    return allResults;
                }

3、贪心算法
        
        在当下选择最好或者最优的选择，从而希望结果是全局最好或者最优的算法
        贪心算法和动态规划区别
            贪心算法：对每个子问题的解决方案做出选择，不能回退，可以解决一些最优化问题
                    贪心法可以做为辅助算法，解决对结果不特别精确的问题
            动态规划：最优判断+回溯

4、二分查找
        
        前提：目标函数的单调性（单调递增或者递减）
             存在上下界（bounded）
             能够通过索引访问（index accessible）
            //代码模板
             public int BinarySearch(int [] arr ,int num){
                //排序
                Arrays.sort(arr);
                //获取最大值,左索引和右索引
                int left  = 0, right = 0,mid;
                int max = arr[arr.length-1];
        
                while (left<=right){
                    mid = (right - left) / 2 + left;
                    if (arr[mid] == num){
                        return mid;
                        //说明这个数在右面
                    }else if (arr[mid] < num){
                        right = mid+1;
                        //说明这个数在左面
                    }else {
                        left = mid-1;
                    }
                }
                return -1;
            }













