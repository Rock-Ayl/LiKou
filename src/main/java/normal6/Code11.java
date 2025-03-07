package normal6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-08-18
 * 1647. 字符频次唯一的最小删除次数
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * <p>
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * <p>
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * 示例 2：
 * <p>
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * 示例 3：
 * <p>
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅含小写英文字母
 */
public class Code11 {

    public int minDeletions(String s) {
        //桶
        int[] arr = new int[200];
        //循环
        for (char c : s.toCharArray()) {
            //记录桶
            arr[c]++;
        }
        //有多少
        List<Integer> list = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            //如果有
            if (arr[i] != 0) {
                //记录
                list.add(arr[i]);
            }
        }
        //排序
        Collections.sort(list);
        //减去的数
        int size = 0;
        //指针
        int p = list.size() - 2;
        //循环
        while (p >= 0) {
            //当前
            int num = list.get(p);
            //上一个
            int last = list.get(p + 1);
            //如果需要减
            if (num >= last) {
                //要变为的,最小为0
                int min = Math.max(0, last - 1);
                //计算
                list.set(p, min);
                //记录
                size += (num - min);
            }
            //下一个
            p--;
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().minDeletions("az"));
    }

}
