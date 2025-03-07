package normal38;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-12-08
 * 2100. 适合野炊的日子
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你和朋友们准备去野炊。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天的建议出行指数。日子从 0 开始编号。同时给你一个整数 time 。
 * <p>
 * 如果第 i 天满足以下所有条件，我们称它为一个适合野炊的日子：
 * <p>
 * 第 i 天前和后都分别至少有 time 天。
 * 第 i 天前连续 time 天建议出行指数都是非递增的。
 * 第 i 天后连续 time 天建议出行指数都是非递减的。
 * 更正式的，第 i 天是一个适合野炊的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
 * <p>
 * 请你返回一个数组，包含 所有 适合野炊的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：security = [5,3,3,3,5,6,2], time = 2
 * 输出：[2,3]
 * 解释：
 * 第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
 * 第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
 * 没有其他日子符合这个条件，所以日子 2 和 3 是适合野炊的日子。
 * 示例 2：
 * <p>
 * 输入：security = [1,1,1,1,1], time = 0
 * 输出：[0,1,2,3,4]
 * 解释：
 * 因为 time 等于 0 ，所以每一天都是适合野炊的日子，所以返回每一天。
 * 示例 3：
 * <p>
 * 输入：security = [1,2,3,4,5,6], time = 2
 * 输出：[]
 * 解释：
 * 没有任何一天的前 2 天建议出行指数是非递增的。
 * 所以没有适合野炊的日子，返回空数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= security.length <= 105
 * 0 <= security[i], time <= 105
 */
public class Code12 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //初始化递增、递减数组
        int[] addArr = new int[security.length];
        int[] subArr = new int[security.length];
        //初始化
        addArr[0] = 1;
        subArr[0] = 1;
        //循环
        for (int i = 1; i < security.length; i++) {
            //计算
            addArr[i] = security[i] >= security[i - 1] ? addArr[i - 1] + 1 : 1;
            subArr[i] = security[i] <= security[i - 1] ? subArr[i - 1] + 1 : 1;
        }
        //初始化结果列表
        List<Integer> result = new ArrayList<>();
        //循环
        for (int i = time; i < security.length - time; i++) {
            //如果左边是单调递减 && 右边是单调递增的
            if (subArr[i] > time && addArr[i + time] > time) {
                //记录本次结果
                result.add(i);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = new Code12().goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
        System.out.println();
    }

}
