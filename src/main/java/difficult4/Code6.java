package difficult4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-08-28
 * 1363. 形成三的最大倍数
 * 算术评级: 7
 * 第 177 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1823
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 digits，你可以通过按 任意顺序 连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 * <p>
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。如果无法得到答案，请返回一个空字符串。返回的结果不应包含不必要的前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [8,1,9]
 * 输出："981"
 * 示例 2：
 * <p>
 * 输入：digits = [8,6,7,1,0]
 * 输出："8760"
 * 示例 3：
 * <p>
 * 输入：digits = [1]
 * 输出：""
 * 示例 4：
 * <p>
 * 输入：digits = [0,0,0,0,0,0]
 * 输出："0"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 10^4
 * 0 <= digits[i] <= 9
 */
public class Code6 {

    public String largestMultipleOfThree(int[] digits) {

        /**
         * 为结果分组
         */

        //分组初始化
        List<List<Integer>> groupList = new ArrayList<>(3);
        //初始化每个分组
        groupList.add(new ArrayList<>());
        groupList.add(new ArrayList<>());
        groupList.add(new ArrayList<>());
        //循环
        for (int digit : digits) {
            //对应分组
            int group = digit % 3;
            //组装
            groupList.get(group).add(digit);
        }
        //排序
        groupList.get(1).sort(Integer::compareTo);
        groupList.get(2).sort(Integer::compareTo);

        /**
         * 找到对应数字结果
         */

        //3、6的倍数,默认直接进来
        List<Integer> resultList = groupList.get(0);
        //余1、余2的结果
        ArrayDeque<Integer> oneList = new ArrayDeque<>(groupList.get(1));
        ArrayDeque<Integer> twoList = new ArrayDeque<>(groupList.get(2));
        //如果需要 3个1
        while (oneList.size() - twoList.size() >= 2 && oneList.size() > 2) {
            //三个1组合
            resultList.add(oneList.pollLast());
            resultList.add(oneList.pollLast());
            resultList.add(oneList.pollLast());
        }
        //如果需要 3个2
        while (twoList.size() - oneList.size() >= 2 && twoList.size() > 2) {
            //三个1组合
            resultList.add(twoList.pollLast());
            resultList.add(twoList.pollLast());
            resultList.add(twoList.pollLast());
        }
        //如果需要 3个1
        if (oneList.size() == 3 && twoList.size() == 1) {
            //三个1组合
            resultList.add(oneList.pollLast());
            resultList.add(oneList.pollLast());
            resultList.add(oneList.pollLast());
        }
        //如果需要 3个2
        if (twoList.size() == 3 && oneList.size() == 1) {
            //三个1组合
            resultList.add(twoList.pollLast());
            resultList.add(twoList.pollLast());
            resultList.add(twoList.pollLast());
        }
        //如果
        while (oneList.size() > 0 && twoList.size() > 0) {
            //各拿一个最大的
            Integer num1 = oneList.pollLast();
            Integer num2 = twoList.pollLast();
            //加入结果列表
            resultList.add(num1);
            resultList.add(num2);
        }
        //排序
        resultList.sort((a, b) -> b.compareTo(a));

        /**
         * 返回结果
         */

        //如果第一个是0
        if (resultList.size() > 0 && resultList.get(0).equals(0)) {
            //直接返回
            return "0";
        }
        //初始化结果
        StringBuilder str = new StringBuilder();
        //循环
        for (Integer number : resultList) {
            //组装
            str.append(number);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Code6().largestMultipleOfThree(new int[]{8, 6, 7, 1, 0, 1, 7, 2}));
        //System.out.println(new Code6().largestMultipleOfThree(new int[]{8, 1, 9}));
        System.out.println(new Code6().largestMultipleOfThree(new int[]{6, 0, 8, 2, 6, 3, 5, 8, 6, 3, 0, 9, 8, 0, 8, 5, 4, 5, 1, 6, 9, 3, 0, 4, 7, 4, 3, 7, 8, 2, 6, 8, 3, 3, 7, 9, 2, 6, 6, 9, 9, 7, 8, 3, 5, 9, 8, 1, 1, 2, 9, 8, 8, 3, 8, 1, 9, 5, 3, 1, 7, 2, 0, 0, 4, 5, 0, 1, 3, 5, 8, 8, 4, 4, 0, 7, 5, 2, 4, 3, 6, 7, 5, 8, 6, 6, 8, 3, 4, 1, 3, 9, 0, 7, 3, 1, 1, 9, 3, 7, 2, 6, 7, 6, 4, 5, 6, 1, 5, 0, 6, 0, 6, 0, 7, 4, 6, 4, 2, 6, 3, 1, 4, 6, 8, 6, 0, 2, 1, 8, 5, 2, 9, 7, 9, 6, 3, 2, 2, 9, 3, 7, 1, 9, 7, 3, 3, 7, 6, 4, 6, 1, 8, 8, 5, 6, 6, 8, 7, 1, 5, 0, 7, 2, 2, 9, 4, 0, 7, 5, 3, 5, 8, 1, 1, 5, 8, 8, 2, 4, 1, 6, 8, 0, 5, 5, 7, 0, 2, 8, 9, 9, 9, 3, 8, 3, 2, 2, 9, 3, 1, 1, 7, 3, 2, 3, 9, 6, 6, 1, 3, 7, 4, 7, 6, 7, 5, 4, 5, 0, 7, 7, 4, 9, 5, 8, 5, 6, 1, 6, 1, 6, 9, 9, 3, 4, 4, 8, 6, 7, 1, 8, 2, 7, 7, 4, 3, 9, 7, 9, 4, 8, 3, 6, 2, 0, 2, 1, 3, 8, 7, 7, 6, 4, 8, 3, 6, 9, 8, 1, 3, 3, 6, 3, 6, 8, 5, 3, 4, 8, 3, 3, 5, 3, 8, 7, 0, 1, 9, 1, 2, 1, 2, 9, 9, 9, 2, 1, 5, 6, 4, 4, 9, 3, 1, 0, 3, 0, 0, 5, 8, 5, 5, 4, 6, 6, 5, 4, 7, 4, 1, 4, 7, 0, 7, 1, 6, 4, 5, 0, 8, 2, 9, 3, 1, 7, 7, 9, 9, 2, 5, 6, 6, 8, 2, 9, 5, 8, 4, 5, 6, 3, 5, 2, 7, 7, 2, 1, 3, 2, 2, 7, 9, 8, 7, 7, 4, 4, 5, 1, 6, 1, 8, 9, 3, 0, 4, 6, 3, 5, 4, 1, 0, 8, 9, 6, 9, 8, 0, 2, 9, 1, 6, 7, 1, 0, 8, 7, 5, 4, 0, 5, 6, 9, 5, 7, 1, 5, 2, 1, 5, 9, 2, 5, 6, 9, 8, 9, 3, 7, 3, 3, 6, 5, 9, 3, 8, 2, 9, 4, 6, 9, 5, 7, 8, 0, 6, 3, 4, 5, 8, 6, 4, 1, 8, 8, 9, 3, 2, 0, 4, 2, 1, 9, 6, 7, 7, 2, 9, 2, 8, 2, 6, 2, 1, 3, 8, 5, 1, 6, 2, 0, 7, 2, 8, 1, 0, 2, 2, 5, 9, 5, 8, 2, 5, 1, 2, 3, 9, 4, 8, 9, 8, 9, 3, 4, 3, 4, 4, 3}));
        //System.out.println(new Code6().largestMultipleOfThree(new int[]{7, 1, 2, 4, 0, 0, 4, 0, 3, 8}));
    }

}