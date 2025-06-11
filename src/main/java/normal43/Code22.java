package normal43;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-06-11
 * 3557. 不相交子字符串的最大数量
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word。
 * <p>
 * 返回以 首尾字母相同 且 长度至少为 4 的 不相交子字符串 的最大数量。
 * <p>
 * 子字符串 是字符串中连续的 非空 字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： word = "abcdeafdef"
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 两个子字符串是 "abcdea" 和 "fdef"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： word = "bcdaaaab"
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 唯一的子字符串是 "aaaa"。注意我们 不能 同时选择 "bcdaaaab"，因为它和另一个子字符串有重叠。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 2 * 105
 * word 仅由小写英文字母组成。
 */
public class Code22 {

    public int maxSubstrings(String word) {

        /**
         * 计算可行分组
         */

        //缓存
        List<Integer>[] allLetterArr = new List[26];
        //循环
        for (int i = 0; i < word.length(); i++) {
            //字符索引
            int index = word.charAt(i) - 'a';
            //判空
            if (allLetterArr[index] == null) {
                //初始化
                allLetterArr[index] = new ArrayList<>();
            }
            //记录索引
            allLetterArr[index].add(i);
        }
        //可行分组列表
        List<int[]> groupList = new ArrayList<>();
        //循环分组
        for (List<Integer> letterList : allLetterArr) {
            //如果不需要
            if (letterList == null || letterList.size() < 2) {
                //本轮过
                continue;
            }
            //跳出标记
            out:
            //循环2
            for (int start = 0; start < letterList.size(); start++) {
                //循环3
                for (int end = start + 1; end < letterList.size(); end++) {
                    //如果满足
                    if (letterList.get(end) - letterList.get(start) >= 3) {
                        //记录可行分组
                        groupList.add(new int[]{letterList.get(start), letterList.get(end)});
                        //本轮过
                        continue out;
                    }
                }
            }
        }

        /**
         * 计算最终结果
         */

        //排序
        groupList.sort((a, b) -> a[0] - b[0]);
        //分组索引
        int groupIndex = 0;
        //动态规划数组
        int[] arr = new int[word.length() + 1];
        //默认0什么都没有是1
        arr[0] = 1;
        //动态规划索引,从1开始
        int arrIndex = 1;
        //循环
        while (arrIndex < arr.length) {
            //如果没有分组了
            if (groupIndex >= groupList.size()) {
                //推进
                arr[arrIndex] = Math.max(arr[arrIndex], arr[arrIndex - 1]);
                //+1
                arrIndex++;
                //本轮过
                continue;
            }
            //获取还未使用的分组
            int[] group = groupList.get(groupIndex);
            //如果还够不到使用分组的条件
            while (arrIndex <= group[0]) {
                //推进
                arr[arrIndex] = Math.max(arr[arrIndex], arr[arrIndex - 1]);
                //+1
                arrIndex++;
            }
            //记录本次使用的最大结果
            arr[group[1] + 1] = Math.max(arr[group[0]] + 1, arr[group[1] + 1]);
            //分组+1
            groupIndex++;
        }

        //返回最大
        return arr[arr.length - 1] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().maxSubstrings("abaeabbcdadcecdcccbbcb"));
    }

}
