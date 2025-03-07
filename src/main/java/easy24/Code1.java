package easy24;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-10-13
 * LCP 66. 最小展台数量
 * 力扣嘉年华将举办一系列展览活动，后勤部将负责为每场展览提供所需要的展台。
 * 已知后勤部得到了一份需求清单，记录了近期展览所需要的展台类型， demand[i][j] 表示第 i 天展览时第 j 个展台的类型。
 * 在满足每一天展台需求的基础上，请返回后勤部需要准备的 最小 展台数量。
 * <p>
 * 注意：
 * <p>
 * 同一展台在不同天中可以重复使用。
 * 示例 1：
 * <p>
 * 输入：demand = ["acd","bed","accd"]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * 第 0 天需要展台 a、c、d；
 * 第 1 天需要展台 b、e、d；
 * 第 2 天需要展台 a、c、c、d；
 * 因此，后勤部准备 abccde 的展台，可以满足每天的展览需求;
 * <p>
 * 示例 2：
 * <p>
 * 输入：demand = ["abc","ab","ac","b"]
 * <p>
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= demand.length,demand[i].length <= 100
 * demand[i][j] 仅为小写字母
 */
public class Code1 {

    public int minNumBooths(String[] demand) {
        //结果列表
        int[] arr = new int[26];
        //每天的结果列表
        int[] thisArr;
        //循环1
        for (String s : demand) {
            //初始化当天
            thisArr = new int[26];
            //循环2
            for (char c : s.toCharArray()) {
                //记录
                thisArr[c - 'a']++;
            }
            //循环3
            for (int i = 0; i < arr.length; i++) {
                //记录最大
                arr[i] = Math.max(arr[i], thisArr[i]);
            }
        }
        //和就是结果
        return Arrays.stream(arr).sum();
    }

}
