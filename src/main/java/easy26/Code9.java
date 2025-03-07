package easy26;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-12-29
 * 2515. 到目标字符串的最短距离
 * 给你一个下标从 0 开始的 环形 字符串数组 words 和一个字符串 target 。环形数组 意味着数组首尾相连。
 * <p>
 * 形式上， words[i] 的下一个元素是 words[(i + 1) % n] ，而 words[i] 的前一个元素是 words[(i - 1 + n) % n] ，其中 n 是 words 的长度。
 * 从 startIndex 开始，你一次可以用 1 步移动到下一个或者前一个单词。
 * <p>
 * 返回到达目标字符串 target 所需的最短距离。如果 words 中不存在字符串 target ，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
 * 输出：1
 * 解释：从下标 1 开始，可以经由以下步骤到达 "hello" ：
 * - 向右移动 3 个单位，到达下标 4 。
 * - 向左移动 2 个单位，到达下标 4 。
 * - 向右移动 4 个单位，到达下标 0 。
 * - 向左移动 1 个单位，到达下标 0 。
 * 到达 "hello" 的最短距离是 1 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
 * 输出：1
 * 解释：从下标 0 开始，可以经由以下步骤到达 "leetcode" ：
 * - 向右移动 2 个单位，到达下标 3 。
 * - 向左移动 1 个单位，到达下标 3 。
 * 到达 "leetcode" 的最短距离是 1 。
 * 示例 3：
 * <p>
 * 输入：words = ["i","eat","leetcode"], target = "ate", startIndex = 0
 * 输出：-1
 * 解释：因为 words 中不存在字符串 "ate" ，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 和 target 仅由小写英文字母组成
 * 0 <= startIndex < words.length
 */
public class Code9 {

    //上一个单词
    public int last(String[] words, int i) {
        //计算并返回
        return (i - 1 + words.length) % words.length;
    }

    //下一个单词
    public int next(String[] words, int i) {
        //计算并返回
        return (i + 1) % words.length;
    }

    //走下去
    public int closetTarget(String[] words, String target, int startIndex) {
        //如果一开始就是目标
        if (words[startIndex].equals(target)) {
            //返回
            return 0;
        }
        //转化为set
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        //如果不存在
        if (set.contains(target) == false) {
            //过
            return -1;
        }
        //走过的路的坐标
        int[] walkArr = new int[words.length];
        //接下来的路
        Set<Integer> nextSet = new HashSet<>();
        //记录起始坐标
        walkArr[startIndex]++;
        nextSet.add(startIndex);
        //次数
        int count = 0;
        //如果还没走完
        while (nextSet.size() > 0) {
            //本次使用次数
            count++;
            //新的下一个路
            Set<Integer> newNextSet = new HashSet<>();
            //循环
            for (Integer p : nextSet) {
                //上一个
                int last = last(words, p);
                //如果是目标
                if (words[last].equals(target)) {
                    //返回结果
                    return count;
                }
                //如果没走过
                if (walkArr[last] == 0) {
                    //记录下一个节点和没走过
                    walkArr[last]++;
                    newNextSet.add(last);
                }
                //下一个
                int next = next(words, p);
                //如果是目标
                if (words[next].equals(target)) {
                    //返回结果
                    return count;
                }
                //如果没走过
                if (walkArr[next] == 0) {
                    //记录下一个节点和没走过
                    walkArr[next]++;
                    newNextSet.add(next);
                }
            }
            //下一组
            nextSet = newNextSet;
        }
        //默认结果
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().closetTarget(new String[]{"a", "b", "leetcode"}, "leetcode", 0));
        ;
    }

}
