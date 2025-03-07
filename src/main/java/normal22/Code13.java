package normal22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-07-28
 * 1239. 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * 子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是：
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * 最大长度为 4。
 * 示例 2：
 * <p>
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 */
public class Code13 {

    //最大可能
    private int maxLength = 0;

    //缓存
    private Set<Character> checkWordSet = new HashSet<>();

    //递归实现
    private void next(List<char[]> wordArr, int p, Set<Character> set) {
        //如果越界了
        if (p >= wordArr.size()) {
            //刷新结果
            maxLength = Math.max(maxLength, set.size());
            //过
            return;
        }
        //下一级
        next(wordArr, p + 1, set);
        //当前单词数组
        char[] charArray = wordArr.get(p);
        //循环1
        for (char c : charArray) {
            //如果存在
            if (set.contains(c)) {
                //跳出
                return;
            }
        }
        //循环2
        for (char c : charArray) {
            //加入
            set.add(c);
        }
        //下一级
        next(wordArr, p + 1, set);
        //循环3
        for (char c : charArray) {
            //回溯
            set.remove(c);
        }
    }

    //如果是不对的单词,返回false
    private boolean checkWord(char[] wordArr) {
        //清空检查缓存
        checkWordSet.clear();
        //循环
        for (char c : wordArr) {
            //如果存在
            if (checkWordSet.contains(c)) {
                //返回
                return false;
            }
            //组装
            checkWordSet.add(c);
        }
        //默认可以
        return true;
    }

    public int maxLength(List<String> arr) {
        //删除不合规的单词,合规的转为数组
        List<char[]> wordArr = arr
                .stream()
                //转化为arr
                .map(String::toCharArray)
                //效验单词是否合规
                .filter(this::checkWord)
                .collect(Collectors.toList());
        //从该点递归实现
        next(wordArr, 0, new HashSet<>());
        //返回结果
        return this.maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().maxLength(Arrays.asList("ab", "ba", "act", "ers")));
    }

}
