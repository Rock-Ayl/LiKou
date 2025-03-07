package normal30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-04-13
 * 433. 最小基因变化
 * 中等
 * 相关标签
 * 相关企业
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 */
public class Code17 {

    //递归实现
    private int count(Set<String> set, Map<String, Integer> map, String target, int count) {
        //下一次可能
        Set<String> nextSet = new HashSet<>();
        //循环
        for (String start : set) {

        }
        //返回
        return 0;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        //初始化缓存
        Map<String, Integer> map = new HashMap<>();
        //初始化集合
        Set<String> set = new HashSet<>();
        //开始
        set.add(startGene);
        map.put(startGene, 0);
        //递归实现并返回
        return count(set, map, endGene, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code17().minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

}
