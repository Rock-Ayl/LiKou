package normal53;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 970. 强整数
 * 算术评级: 3
 * 第 118 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1339
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 * <p>
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 * <p>
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 */
public class Code20 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        //构建所有可能
        List<Integer> num1List = build(x, bound);
        List<Integer> num2List = build(y, bound);
        //结果集
        Set<Integer> resultSet = new HashSet<>();
        //循环
        for (Integer one : num1List) {
            //循环2
            for (Integer two : num2List) {
                //本次结果
                int sum = one + two;
                //如果满足条件
                if (sum <= bound) {
                    //记录
                    resultSet.add(sum);
                }
            }
        }
        //返回
        return new ArrayList<>(resultSet);
    }

    //构建所有可能
    private List<Integer> build(int num, int bound) {
        //列表
        List<Integer> result = new ArrayList<>();
        //如果num为1，直接返回1即可
        if (num == 1) {
            //直接记录
            result.add(1);
            //返回
            return result;
        }
        //数字
        int enumNum = 1;
        //循环
        while (enumNum <= bound) {
            //记录
            result.add(enumNum);
            //下一个
            enumNum = enumNum * num;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = new Code20().powerfulIntegers(2, 1, 10);
        System.out.println();
    }

}
