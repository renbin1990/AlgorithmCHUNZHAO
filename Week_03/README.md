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