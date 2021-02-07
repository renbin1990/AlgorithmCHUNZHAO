package DFSorBFS;

import java.util.HashSet;

/**
 * 433. 最小基因变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * <p>
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * <p>
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * <p>
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意：
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 */
public class minMutation {
    public static void main(String[] args) {

    }

    int minStepCount = Integer.MAX_VALUE;

    //一般能想到的回溯的方式是逐个改变基因中的碱基(A、C、G、T)，当改变后的基因在基因库中 步数+1 并进入下一层。
    //但题目中说明了每一次基因变化都属于基因库，那么遍历基因库，找到库中与当前基因相差一个碱基的就是下一步变化的基因，这时步数+1并进入下一层会比上面的方式省很多。
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void dfs(HashSet<String> step, int stepCount, String current, String end, String[] bank) {
        //说明匹配成功
        if (current.equals(end)) {
            minStepCount = Math.min(stepCount, minStepCount);
        } else {
            for (String str : bank) {
                int diff = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (current.charAt(i) != str.charAt(i)) {
                        if (++diff > 1) {
                            break;
                        }
                    }
                }


                if (diff == 1 && !step.contains(str)) {
                    step.add(str);
                    dfs(step, stepCount + 1, str, end, bank);
                    step.remove(str);
                }

            }
        }
    }
}
