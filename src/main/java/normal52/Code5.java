package normal52;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3890. 可由多种立方和构造的整数
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 当存在 至少 两组不同的整数对 (a, b) 满足以下条件时，整数 x 被称为 好整数：
 * <p>
 * a 和 b 是正整数。
 * a <= b
 * x = a3 + b3
 * 返回一个数组，其中包含所有小于等于 n 的好整数，并按升序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 4104
 * <p>
 * 输出： [1729,4104]
 * <p>
 * 解释：
 * <p>
 * 在小于等于 4104 的整数中，好整数包括：
 * <p>
 * 1729：13 + 123 = 1729，以及 93 + 103 = 1729。
 * 4104：23 + 163 = 4104，以及 93 + 153 = 4104。
 * 因此，答案是 [1729, 4104]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 578
 * <p>
 * 输出： []
 * <p>
 * 解释：
 * <p>
 * 不存在小于等于 578 的好整数，因此答案是空数组。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code5 {

    public List<Integer> findGoodIntegers(int n) {

        /**
         * 构建枚举
         */

        //列表缓存
        List<Integer> numList = new ArrayList<>();
        //循环
        for (int i = 1; i <= n; i++) {
            //数字
            int num = i * i * i;
            //如果满足
            if (num > 0 && num <= n) {
                //记录
                numList.add(num);
            } else {
                //跳出
                break;
            }
        }

        /**
         * 计算所有可能
         */

        //计数器
        Map<Integer, Integer> countMap = new HashMap<>();
        //跳出
        out:
        //循环
        for (int i = 0; i < numList.size(); i++) {
            //第一个数字
            int a = numList.get(i);
            //循环2
            for (int j = i + 1; j < numList.size(); j++) {
                //第二个数字
                int b = numList.get(j);
                //求和
                int sum = a + b;
                //如果不满足
                if (sum < 0 || sum > n) {
                    //本轮过
                    continue out;
                }
                //+1
                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            }
        }

        /**
         * 返回结果
         */

        //返回
        return countMap
                .entrySet()
                .stream()
                //过滤无效数据
                .filter(p -> p.getValue().equals(1) == false)
                //拆解key
                .map(Map.Entry::getKey)
                //排序
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> goodIntegers = new Code5().findGoodIntegers(4104);
        System.out.println();
    }

}